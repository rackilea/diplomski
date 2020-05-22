public class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location loc) {

            double lati = loc.getLatitude();
            double longi = loc.getLongitude();

            mlocManager.remoteUpdates(this); // ADD THIS STATEMENT

            // The rest of your code goes here ...

        }

   }