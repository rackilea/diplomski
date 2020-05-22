package com.example.lastdemo;

import java.util.ArrayList;
import java.util.List;
import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewFrame;
import org.opencv.android.CameraBridgeViewBase.CvCameraViewListener2;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.imgproc.Imgproc;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.SurfaceView;
import android.view.WindowManager;


public class MainActivity extends Activity implements CvCameraViewListener2 {

    private static final String TAG = "OCVSample::Activity";

    public Bitmap newBitmap,bitmap;
    public int no;
    public Mat mBin,dist_8u;
    public Bitmap bmpBinary;
    public Mat imageMat;
    public List<MatOfPoint> contours = new ArrayList<MatOfPoint>(); 
    public Mat hierarchy;

    public Mat mRgba;
    public Mat mGray;
    public Mat mTemp,mTemp1;

    private CameraBridgeViewBase mOpenCvCameraView;


    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case LoaderCallbackInterface.SUCCESS:
                {
                    Log.i(TAG, "OpenCV loaded successfully");
                    mOpenCvCameraView.enableView();
                    //mOpenCvCameraView.setOnTouchListener(MainActivity.this );
                } break;
                default:
                {
                    super.onManagerConnected(status);
                } break;
            }
        }
    };

    public MainActivity() {
        Log.i(TAG, "Instantiated new " + this.getClass());
    }    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "called onCreate");
        super.onCreate( savedInstanceState );
        getWindow().addFlags( WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON );
        setContentView(R.layout.tutorial1_surface_view);
        mOpenCvCameraView = (CameraBridgeViewBase) findViewById ( R.id.tutorial1_activity_java_surface_view );
        mOpenCvCameraView.setVisibility( SurfaceView.VISIBLE );
        mOpenCvCameraView.setCvCameraViewListener(this);


    }

    @Override
    public void onPause()
    {
        super.onPause();
        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_3, this,
                               mLoaderCallback);
    }

    public void onDestroy() {
        super.onDestroy();
        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }

    public void onCameraViewStarted(int width, int height) {
        mGray = new Mat();
        mRgba = new Mat();

    }

    public void onCameraViewStopped() {
    }

    public Mat onCameraFrame(CvCameraViewFrame inputFrame) {

        mRgba = inputFrame.rgba();
        Imgproc.cvtColor(mRgba, mGray, Imgproc.COLOR_BGRA2GRAY);

    /*Bitmap resultBitmap = Bitmap.createBitmap(mGray.cols(), mGray.rows(),Bitmap.Config.ARGB_8888);; 
    Utils.matToBitmap(mGray, resultBitmap);
       Bitmap mResult = resultBitmap;

    toBinary(mResult);

     imageMat = new Mat(bmpBinary.getHeight(), bmpBinary.getWidth(), CvType.CV_8U,new Scalar(4));
     Bitmap myBitmap32 = bmpBinary.copy(Bitmap.Config.ARGB_8888, true);
     Utils.bitmapToMat(myBitmap32, imageMat);*/



        Imgproc.threshold(mGray, mBin, 40, 255, Imgproc.THRESH_BINARY);
        //Imgproc.distanceTransform_0(imageMat.nativeObj, mTemp.nativeObj, Imgproc.DIST_LABEL_PIXEL, 3);
        Imgproc.distanceTransform(mBin, mTemp, Imgproc.DIST_LABEL_PIXEL, 3);
        Core.normalize(mTemp, mBin, 0, 1., Core.NORM_MINMAX);
        Imgproc.threshold(mBin, mBin, .5, 1., Imgproc.THRESH_BINARY);
        mBin.convertTo(dist_8u, CvType.CV_8U);
        mTemp1 = dist_8u;
        hierarchy = new Mat();
        Imgproc.findContours(dist_8u, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
        no = contours.size();

        return mTemp1;


    /*Bitmap resultBitmap = Bitmap.createBitmap(mGray.cols(), mGray.rows(),Bitmap.Config.ARGB_8888);; 
    Utils.matToBitmap(mGray, resultBitmap);
       Bitmap mResult = resultBitmap;

    toBinary(mResult);

     imageMat = new Mat(bmpBinary.getHeight(), bmpBinary.getWidth(), CvType.CV_8U,new Scalar(4));
     Bitmap myBitmap32 = bmpBinary.copy(Bitmap.Config.ARGB_8888, true);
     Utils.bitmapToMat(myBitmap32, imageMat);*/

/*      Imgproc.cvtColor(imageMat, mRgba, Imgproc.COLOR_BayerBG2BGR);
        Imgproc.threshold(imageMat, imageMat, 40, 255, Imgproc.THRESH_BINARY);
        Imgproc.distanceTransform(imageMat, mTemp, Imgproc.DIST_LABEL_PIXEL, 3);
        Core.normalize(mTemp, imageMat, 0, 1., Core.NORM_MINMAX);
        Imgproc.threshold(imageMat, mBin, .5, 1., Imgproc.THRESH_BINARY);
        mBin.convertTo(dist_8u, CvType.CV_8U);
        mTemp1 = dist_8u;
        hierarchy = new Mat();
        Imgproc.findContours(dist_8u, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
        no = contours.size();*/

    }

    public void toBinary(Bitmap mGray) {

        int width, height, threshold;
        height = mGray.getHeight();
        width = mGray.getWidth();
        threshold = 32;
        bmpBinary = Bitmap.createBitmap(mGray);

        for(int x = 0; x < width; ++x) {
            for(int y = 0; y < height; ++y) {
                // get one pixel color
                int pixel = mGray.getPixel(x, y);
                int red = Color.red(pixel);

                //get binary value
                if(red < threshold){
                    bmpBinary.setPixel(x, y, 0xFF000000);
                } else{
                    bmpBinary.setPixel(x, y, 0xFFFFFFFF);
                }

            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}