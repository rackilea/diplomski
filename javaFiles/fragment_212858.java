protected void onResume() {
     super.onResume();
     mSensorManager.registerListener(this, mAccelerometer,
                                     SensorManager.SENSOR_DELAY_NORMAL);
 }

 protected void onPause() {
     super.onPause();
     mSensorManager.unregisterListener(this);
 }