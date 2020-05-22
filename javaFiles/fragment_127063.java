new AsyncTask<Void, Void, Void>() {
        @Override
        protected Void doInBackground(Void... unusedParams) {
            // TODO: do your database stuff
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            // TODO: refresh UI elements, because thread finished
            super.onPostExecute(aVoid);
        }
    }.execute();