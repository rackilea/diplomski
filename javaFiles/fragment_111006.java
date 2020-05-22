public void onCreate()
{
    super.onCreate();
    setContentView(R.layout.myLayout);
    [other activity initialization code]
    mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
    mSensorManager.registerListener(this, mSensorManager
            .getDefaultSensor(Sensor.TYPE_LIGHT),
            SensorManager.SENSOR_DELAY_FASTEST);
}