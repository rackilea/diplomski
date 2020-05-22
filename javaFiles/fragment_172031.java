Integer gpsFreqInMillis = 1000;
Integer gpsFreqInDistance = 1;  // in meters

locationManager.addGpsStatusListener(this);

locationManager.requestLocationUpdates(gpsFreqInMillis, gpsFreqInDistance, criteria, this, null);