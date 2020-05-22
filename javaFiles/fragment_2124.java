chrono.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
      @Override
      public void onChronometerTick(Chronometer chronometer) {
              if(chronometer.getText().toString().equalsIgnoreCase("00:05")) {
                        // Reset Chronometer
                        chronometer.setOnChronometerTickListener(null);
                        chronometer.stop();
                        chronometer.setBase(SystemClock.elapsedRealtime());


              }
      }
});