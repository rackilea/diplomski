public class MainActivity extends ActionBarActivity implements SensorEventListener {

    private float mLastX, mLastY, mLastZ;
    ...
    mSensorManager = (SensorManager) getSystemService(Context.SEARCH_SERVICE);
    mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
}
}  // Delete this line!