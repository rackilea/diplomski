@Override
protected void onGpsTracker_ButtonAction(Component c, ActionEvent event) {
    try {
        int i = 0;
        Location loc = mylocLocationManager.getCurrentLocation();
        if (loc.getStatus() == LocationManager.AVAILABLE) {
            System.out.println("Location available");
        } else {
            Dialog.show("Error!", "Falla de señal", "OK", null);
        }
        final LocationManager mylocLocationManager = LocationManager.getLocationManager();
        mylocLocationManager.setLocationListener(new LocationListener() {
            @Override
            public void locationUpdated(Location location) {
                gpsLocation = location;
                Label labelspeed = ;
                altmax = location.getAltitude();
                double lat = location.getLatitude();
                double lng = location.getLongitude();
                float speed = location.getVelocity();

                double alt = location.getAltitude();
                velprompos = velprompos + 1;
                totspeed = (int) (totspeed + speed);
                velopro = totspeed / velprompos;
                totalt = altmax - alt;

                velmax = speed;
                Coord lastLocation = new Coord(lat, lng);
                mapComponent.zoomTo(lastLocation, 15);

                prevdistance = totdistance;
                prevLon = currentLon;
                prevLat = currentLat;
                String Salt = String.valueOf(alt);
                findAltitudT(c).setText(Salt);
                String Slat = String.valueOf(lat);
                findLatitudT(c).setText(Slat);
                String Slng = String.valueOf(lng);
                findLongitudT(c).setText(Slng);
                String Sspeed = String.valueOf(speed);
                findSpeedT(c).setText(Sspeed);

                c.getComponentForm().revalidate();
                //aca hay q pner dibujo lineas  
            }

            @Override
            public void providerStateChanged(int newState) {
                //positionMethod();
            }
        });

    } catch (Exception ex) {
        ex.printStackTrace();
        gpsLocation = null;
    }
}