private static final float NS2S = 1.0f / 1000000000.0f;
 private float timestamp;

 public void onSensorChanged(SensorEvent event) {
      // This timestep's delta rotation to be multiplied by the current rotation
      // after computing it from the gyro sample data.
      if (timestamp != 0) {
          final float dT = (event.timestamp - timestamp) * NS2S;