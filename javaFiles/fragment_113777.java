public class AsyncCustomTask extends AsyncTask<Void, Void, List<String>> {

        @Override
        protected List<String> doInBackground(Void... params) {
                return getEvacRouteNames();
            }

            @Override
        protected void onPostExecute(List<String> result) {
            // Function finished and value has returned.
        }

    }