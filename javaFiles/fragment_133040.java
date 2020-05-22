Timer timer = new Timer ();
    TimerTask hourlyTask = new TimerTask () {
    @Override
    public void run () {
        // check if GPS enabled
        GPSTracker gpsTracker = new GPSTracker(this);
        if (gpsTracker.getIsGPSTrackingEnabled()){
            String stringLatitude = String.valueOf(gpsTracker.latitude);
            String stringLongitude = String.valueOf(gpsTracker.longitude);
            }
        }
    };

// schedule the task to RUN every hour
timer.schedule (hourlyTask, 0l, 1000*60*60);   // 1000*10*60 every 10 minut