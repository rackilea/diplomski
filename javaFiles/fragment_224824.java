mPerth = mMap
        .addMarker(new MarkerOptions()
        .position(SECC)
        .title("SECC")
        .snippet("Exhibition Way, Glasgow, G3 8YW\nSports: Boxing, Gymnastics, Judo, Netball, Wrestling, Weightlifting"));

        Timer timer = new Timer();
        TimerTask updateProfile = new CustomTimerTask(youractivity.this); 
        timer.scheduleAtFixedRate(updateProfile, 10,5000);
        mPerth.showInfoWindow();
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(SECC, 18.0f));