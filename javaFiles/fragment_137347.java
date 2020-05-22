public void onSensorChanged(SensorEvent event)
 {
      // alpha is calculated as t / (t + dT)
      // with t, the low-pass filter's time-constant
      // and dT, the event delivery rate

      final float alpha = 0.8;

      gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
      gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
      gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];

      linear_acceleration[0] = event.values[0] - gravity[0];
      linear_acceleration[1] = event.values[1] - gravity[1];
      linear_acceleration[2] = event.values[2] - gravity[2];
 }