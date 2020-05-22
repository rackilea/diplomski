if (time >= 100000) {
                latitude = 0;
                longitude = 0;
            }
        } catch (NullPointerException e) {
            // TODO: handle exception
            System.out.println("Null");
            e.printStackTrace();
        } 
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        runAsyncTask();    
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        locationManager.removeUpdates(locationListener);
    }

    public void setCriteria() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_MEDIUM);
        provider = locationManager.getBestProvider(criteria, true);
        Toast.makeText(getApplicationContext(), "Provider - " + provider, Toast.LENGTH_SHORT).show();
        if (provider == null) {
            provider = LocationManager.GPS_PROVIDER;
        }
    }    


    public void runAsyncTask() {
        // TODO Auto-generated method stub
        if (getCurrentLocation == null) {
            getCurrentLocation = new CurrentPositionTask();    
        }

        if (getCurrentLocation != null) {
            getCurrentLocation.execute("Searching for Location");    
        }
    }

    public boolean checkConnection()
    {
        //ARE WE CONNECTED TO THE NET

        ConnectivityManager conMgr = (ConnectivityManager) getSystemService (AndroidLocationActivity.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable()&& conMgr.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    } 


    private class CurrentPositionTask extends AsyncTask<String, Void, Void>
    {
        private ProgressDialog Dialog = new ProgressDialog(AndroidLocationActivity.this);
        private boolean flag = true;

        public CurrentPositionTask() {
            locationListener = new MyLocationListener();
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            try {
                if (checkConnection()) {
                    Dialog.setTitle("Loading");
                    Dialog.setMessage("Searching for Location");
                    Dialog.show();
                    locationManager.requestLocationUpdates(provider, 0, 0, locationListener);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Internet is Not Available", Toast.LENGTH_LONG).show();
                }    
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

        @Override
        protected Void doInBackground(String... params) {
            // TODO Auto-generated method stub
            while (flag) {
                if (latitude !=0 && longitude != 0) {
                    flag=false;
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            Toast.makeText(AndroidLocationActivity.this, "Location Floats:- " + latitude + "," + longitude, Toast.LENGTH_LONG).show();

            super.onPostExecute(result);
            if (Dialog != null && Dialog.isShowing()) {
                Dialog.dismiss();
                time=0;
                Intent homeIntent = new Intent(AndroidLocationActivity.this.getApplicationContext(), HomeMenuActivity.class);