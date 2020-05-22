startButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);

        }
    })