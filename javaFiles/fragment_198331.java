I also send some references...
    http://developer.android.com/resources/samples/AccelerometerPlay/index.html
my code    
    import android.app.Activity;
    import android.content.res.AssetFileDescriptor;
    import android.hardware.Sensor;
    import android.hardware.SensorEvent;
    import android.hardware.SensorEventListener;
    import android.hardware.SensorManager;
    import android.media.MediaPlayer;
    import android.media.MediaPlayer.OnCompletionListener;
    import android.os.Bundle;

    public class SensorTest extends Activity implements SensorEventListener {
        private SensorManager sensorManager;
        private boolean color = false;
        private long lastUpdate;
        private MediaPlayer mMediaplayer;

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            sensorManager.registerListener(this, sensorManager
                    .getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                    SensorManager.SENSOR_DELAY_NORMAL);
            lastUpdate = System.currentTimeMillis();
        }

        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                float[] values = event.values;
                // Movement
                float x = values[0];
                float y = values[1];
                float z = values[2];

                float accelationSquareRoot = (x * x + y * y + z * z)
                        / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
                long actualTime = System.currentTimeMillis();
                if (accelationSquareRoot >= 2) //
                {
                    if (actualTime - lastUpdate < 200) {
                        return;
                    }
                    lastUpdate = actualTime;

                    if (color) {

                    } else {
                        try {

                            AssetFileDescriptor afd = getAssets().openFd(
                                    "gavel_single.wav");
                            mMediaplayer = new MediaPlayer();
                            mMediaplayer.setDataSource(afd.getFileDescriptor(), afd
                                    .getStartOffset(), afd.getLength());
                            afd.close();
                            mMediaplayer.prepare();
                            mMediaplayer.start();

                            mMediaplayer
                                    .setOnCompletionListener(new OnCompletionListener() {

                                        public void onCompletion(MediaPlayer mp) {
                                            mp.stop();
                                            mp.release();

                                        }
                                    });

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                }

            }

        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
            // TODO Auto-generated method stub

        }

        @Override
        protected void onResume() {
            super.onResume();
            // register this class as a listener for the orientation and
            // accelerometer sensors
            sensorManager.registerListener(this, sensorManager
                    .getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

        @Override
        protected void onPause() {
            // unregister listener
            sensorManager.unregisterListener(this);
            super.onStop();
        }

        @Override
        protected void onDestroy() {

            super.onDestroy();
            if (mMediaplayer != null) {
                mMediaplayer.release();
                mMediaplayer = null;
            }

        }
    }