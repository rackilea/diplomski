new AsyncTask<Void, Void, Void>() {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //TODO: show your dialog from here
        }

        @Override
        protected Void doInBackground(Void... params) {
            //TODO: call Calculations(128); from here
            //Calculations(128); should live within this async task instead of a new activity
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //TODO: call dismiss on your dialog from here
        }
    }.execute();