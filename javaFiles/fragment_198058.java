...
Handler handler = new Handler(Looper.getMainLooper());
handler.post(new Runnable() {
            @Override
            public void run() {
                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

                LocationListener locationListener = new MyLocationListener();

                locationManager.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
            });
...