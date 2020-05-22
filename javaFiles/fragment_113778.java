public class AsyncSecondCustomTask extends AsyncTask<Void, Void, EvacRoute> {

        private final String routeName;
        private final LatLng currentLocation;
        private final String lat;
        private final String lon;

        public AsyncSecondCustomTask(String routeName, LatLng currentLocation, String lat, String lon) {
            this.routeName = routeName;
            this.currentLocation = currentLocation;
            this.lat = lat;
            this.lon = lon;
        }

        @Override
        protected EvacRoute doInBackground(Void... params) {
            return getEvacuationRoute(routeName, currentLocation, lat, lon);
        }

        @Override
        protected void onPostExecute(EvacRoute result) {
            // Function finished and value has returned.
        }

    }