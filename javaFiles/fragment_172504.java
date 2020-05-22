package com.example.videotest;


import java.io.File;
import java.io.IOException;
import java.nio.ShortBuffer;
import java.util.List;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import com.googlecode.javacv.FFmpegFrameRecorder;
import com.googlecode.javacv.FrameRecorder.Exception;
import com.googlecode.javacv.cpp.opencv_core.IplImage;

import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity implements CvCameraViewListener2{

    private CameraView cameraView;
    private Mat edgesMat;
    private final Scalar greenScalar = new Scalar(0,255,0);
    private int resolutionIndex = 0;

    private IplImage videoImage = null;

    boolean recording = false;
    private volatile FFmpegFrameRecorder recorder;

    private int sampleAudioRateInHz = 44100;
    private int imageWidth = 320;
    private int imageHeight = 240;
    private int frameRate = 30;

    private Thread audioThread;
    volatile boolean runAudioThread = true;
    private AudioRecord audioRecord;
    private AudioRecordRunnable audioRecordRunnable;

    private String ffmpeg_link;

    long startTime = 0;

    private String LOG_TAG = "VideoTest";

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
            case LoaderCallbackInterface.SUCCESS:
                Log.i("VideoTest", "OpenCV loaded successfully");
                cameraView.enableView();
                break;
            default:
                super.onManagerConnected(status);
                break;
            }
        }
    };


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        setContentView(R.layout.activity_main);

        cameraView = (CameraView) findViewById(R.id.cameraView);
        cameraView.setVisibility(SurfaceView.VISIBLE);
        cameraView.setCvCameraViewListener(this);
    }

    private void initRecorder() {
        Log.w(LOG_TAG,"initRecorder");

        int depth = com.googlecode.javacv.cpp.opencv_core.IPL_DEPTH_8U;
        int channels = 4;

        // if (yuvIplimage == null) {
        // Recreated after frame size is set in surface change method
        videoImage = IplImage.create(imageWidth, imageHeight, depth, channels);
        //yuvIplimage = IplImage.create(imageWidth, imageHeight, IPL_DEPTH_32S, 2);

        Log.v(LOG_TAG, "IplImage.create");
        // }

        File videoFile = new File(getExternalFilesDir(null), "VideoTest/images/video.mp4");
        boolean mk = videoFile.getParentFile().mkdirs();
        Log.v(LOG_TAG, "Mkdir: " + mk);

        boolean del = videoFile.delete();
        Log.v(LOG_TAG, "del: " + del);

        try {
            boolean created = videoFile.createNewFile();
            Log.v(LOG_TAG, "Created: " + created);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ffmpeg_link = videoFile.getAbsolutePath();
        recorder = new FFmpegFrameRecorder(ffmpeg_link, imageWidth, imageHeight, 1);
        Log.v(LOG_TAG, "FFmpegFrameRecorder: " + ffmpeg_link + " imageWidth: " + imageWidth + " imageHeight " + imageHeight);

        recorder.setFormat("mp4");
        Log.v(LOG_TAG, "recorder.setFormat(\"mp4\")");

        recorder.setSampleRate(sampleAudioRateInHz);
        Log.v(LOG_TAG, "recorder.setSampleRate(sampleAudioRateInHz)");

        // re-set in the surface changed method as well
        recorder.setFrameRate(frameRate);
        Log.v(LOG_TAG, "recorder.setFrameRate(frameRate)");

        // Create audio recording thread
        audioRecordRunnable = new AudioRecordRunnable();
        audioThread = new Thread(audioRecordRunnable);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        if (cameraView != null){
            cameraView.disableView();
        }
    }

    @Override
    public void onResume()
    {
        super.onResume();
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_3, this, mLoaderCallback);
    }

    public void onDestroy() {
        super.onDestroy();
        if (cameraView != null)
            cameraView.disableView();
    }

    public void onCameraViewStarted(int width, int height) {
        edgesMat = new Mat();
    }

    public void onCameraViewStopped() {
        if (edgesMat != null)
            edgesMat.release();

        edgesMat = null;
    }

    public Mat onCameraFrame(CvCameraViewFrame inputFrame) {

        Mat rgba = inputFrame.rgba();
        org.opencv.core.Size sizeRgba = rgba.size();

        int rows = (int) sizeRgba.height;
        int cols = (int) sizeRgba.width;

        int left = cols / 8;
        int top = rows / 8;
        int width = cols * 3 / 4;
        int height = rows * 3 / 4;

        //get sub-image
        Mat rgbaInnerWindow = rgba.submat(top, top + height, left, left + width);

        //create edgesMat from sub-image
        Imgproc.Canny(rgbaInnerWindow, edgesMat, 100, 100);

        Mat colorEdges = new Mat();
        Mat killMe = colorEdges;
        edgesMat.copyTo(colorEdges);
        Imgproc.cvtColor(colorEdges, colorEdges, Imgproc.COLOR_GRAY2BGRA);


        colorEdges = colorEdges.setTo(greenScalar, edgesMat);
        colorEdges.copyTo(rgbaInnerWindow, edgesMat);

        killMe.release();
        colorEdges.release();

        rgbaInnerWindow.release();

        if(recording){
            byte[] byteFrame = new byte[(int) (rgba.total() * rgba.channels())];
            rgba.get(0, 0, byteFrame);
            onFrame(byteFrame);
        }

        return rgba;
    }

    public void stopRecording() {
        // This should stop the audio thread from running
        runAudioThread = false;

        if (recorder != null) {
            Log.v(LOG_TAG,"Finishing recording, calling stop and release on recorder");
            try {
                recorder.stop();
                recorder.release();
            } catch (FFmpegFrameRecorder.Exception e) {
                e.printStackTrace();
            }
            recorder = null;
        }

        MediaScannerConnection.scanFile(MainActivity.this, new String[]{ffmpeg_link}, null, null);
    }


    public void changeResolution(View v){
        List<android.hardware.Camera.Size> cameraResolutionList = cameraView.getResolutionList();
        resolutionIndex++;
        if(resolutionIndex >= cameraResolutionList.size()){
            resolutionIndex = 0;
        }

        android.hardware.Camera.Size resolution = cameraResolutionList.get(resolutionIndex);
        cameraView.setResolution(resolution.width, resolution.height);
        resolution = cameraView.getResolution();
        String caption = Integer.valueOf(resolution.width).toString() + "x" + Integer.valueOf(resolution.height).toString();
        Toast.makeText(this, caption, Toast.LENGTH_SHORT).show();

        imageWidth = resolution.width;
        imageHeight = resolution.height;

        frameRate = cameraView.getFrameRate();

        initRecorder();
    }

    int frames = 0;

    private void onFrame(byte[] data){

        if (videoImage != null && recording) {
            long videoTimestamp = 1000 * (System.currentTimeMillis() - startTime);

            // Put the camera preview frame right into the yuvIplimage object
            videoImage.getByteBuffer().put(data);

            try {

                // Get the correct time
                recorder.setTimestamp(videoTimestamp);

                // Record the image into FFmpegFrameRecorder
                recorder.record(videoImage);

                frames++;

                Log.i(LOG_TAG, "Wrote Frame: " + frames);

            } 
            catch (FFmpegFrameRecorder.Exception e) {
                Log.v(LOG_TAG,e.getMessage());
                e.printStackTrace();
            }
        }

    }

    public void startVideo(View v){

        recording = !recording;

        Log.i(LOG_TAG, "Recording: " + recording);

        if(recording){
            startTime = System.currentTimeMillis();
            try {
                recorder.start();

                Log.i(LOG_TAG, "STARTED RECORDING.");

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else{
            stopRecording();
        }
    }



    class AudioRecordRunnable implements Runnable {

        @Override
        public void run() {
            // Set the thread priority
            android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_URGENT_AUDIO);

            // Audio
            int bufferSize;
            short[] audioData;
            int bufferReadResult;

            bufferSize = AudioRecord.getMinBufferSize(sampleAudioRateInHz, 
                    AudioFormat.CHANNEL_CONFIGURATION_MONO, AudioFormat.ENCODING_PCM_16BIT);
            audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC, sampleAudioRateInHz, 
                    AudioFormat.CHANNEL_CONFIGURATION_MONO, AudioFormat.ENCODING_PCM_16BIT, bufferSize);

            audioData = new short[bufferSize];

            Log.d(LOG_TAG, "audioRecord.startRecording()");
            audioRecord.startRecording();

            // Audio Capture/Encoding Loop
            while (runAudioThread) {
                // Read from audioRecord
                bufferReadResult = audioRecord.read(audioData, 0, audioData.length);
                if (bufferReadResult > 0) {
                    //Log.v(LOG_TAG,"audioRecord bufferReadResult: " + bufferReadResult);

                    // Changes in this variable may not be picked up despite it being "volatile"
                    if (recording) {
                        try {
                            // Write to FFmpegFrameRecorder
                            recorder.record(ShortBuffer.wrap(audioData, 0, bufferReadResult));
                        } catch (FFmpegFrameRecorder.Exception e) {
                            Log.v(LOG_TAG,e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }
            }
            Log.v(LOG_TAG,"AudioThread Finished");

            /* Capture/Encoding finished, release recorder */
            if (audioRecord != null) {
                audioRecord.stop();
                audioRecord.release();
                audioRecord = null;

                MediaScannerConnection.scanFile(MainActivity.this, new String[]{ffmpeg_link}, null, null);

                Log.v(LOG_TAG,"audioRecord released");
            }
        }
    }

}