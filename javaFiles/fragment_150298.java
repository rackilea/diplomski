private final SensorManager mSensorManager;
private final Sensor mLightSensor;
private float mLightQuantity;

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    // Obtain references to the SensorManager and the Light Sensor
    mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
    mLightSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

    // Implement a listener to receive updates
    SensorEventListener listener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            mLightQuantity = event.values[0];
        }
    }

    // Register the listener with the light sensor -- choosing
    // one of the SensorManager.SENSOR_DELAY_* constants.
    mSensorManager.registerListener(
            listener, lightSensor, SensorManager.SENSOR_DELAY_UI);
}