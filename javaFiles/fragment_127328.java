homeIntent.putExtra("lat", latitude);
    homeIntent.putExtra("lng", longitude);
            startActivity(homeIntent);
            }
            locationManager.removeUpdates(locationListener);
        }
    }

    class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            // TODO Auto-generated method stub
            if (location != null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();    
            }
        }

        @Override
        public void onProviderDisabled(String arg0) {
            // TODO Auto-generated method stub
            Toast.makeText( getApplicationContext(),"Gps Disabled",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onProviderEnabled(String arg0) {
            // TODO Auto-generated method stub
            Toast.makeText( getApplicationContext(),"Gps Enabled",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
            // TODO Auto-generated method stub
        }
    }