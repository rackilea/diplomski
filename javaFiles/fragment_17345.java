package com.zihadrizkyef.belajaraudiocapture;

    import android.media.MediaPlayer;
    import android.media.MediaRecorder;
    import android.os.Environment;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.Toast;

    import java.io.IOException;

    public class MainActivity extends AppCompatActivity {
        Button btnPlay, btnStop, btnStart;
        MediaRecorder myAudioRecorder;
        String outputFile = null;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            btnPlay = (Button) findViewById(R.id.btnRecordPlay);
            btnStart = (Button) findViewById(R.id.btnRecordStart);
            btnStop = (Button) findViewById(R.id.btnRecordStop);

            btnPlay.setEnabled(false);
            btnStop.setEnabled(false);


            btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
outputFile = Environment.getExternalStorageDirectory().getAbsolutePath()+"/recording.3gpp";
    //Creating MediaRecorder and specifying audio source, output format, encoder & output format  
            myAudioRecorder = new MediaRecorder();


            myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
            myAudioRecorder.setOutputFile(outputFile);
                        myAudioRecorder.prepare();
                        myAudioRecorder.start();
                    } catch (IOException | IllegalStateException e) {
                        e.printStackTrace();
                    }

                    btnStart.setEnabled(false);
                    btnStop.setEnabled(true);

                    Toast.makeText(MainActivity.this, "Recording started", Toast.LENGTH_SHORT).show();
                }
            });

            btnStop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myAudioRecorder.stop();
                    myAudioRecorder.release();
                    /*myAudioRecorder = null;*/

                    btnPlay.setEnabled(true);
                    btnStart.setEnabled(true);
                    btnStop.setEnabled(false);

                    Toast.makeText(MainActivity.this, "Audio recorded successfully", Toast.LENGTH_SHORT).show();
                }
            });

            btnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mediaPlayer = new MediaPlayer();

                    try {
                        mediaPlayer.setDataSource(outputFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    try {
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    mediaPlayer.start();
                    Toast.makeText(MainActivity.this, "Playing audio", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }