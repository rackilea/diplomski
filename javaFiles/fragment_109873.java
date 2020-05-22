class ConnectionTask new AsyncTask<Void, Void, Boolean>() {
        @Override
        protected Void doInBackground(Void... params) {
            //...your code

        }
        @Override
        protected void onPostExecute(Boolean result) {
            if(result) {
                listner.onConnectionSuccess();
            } else {
                listner.onConnectionFailed();
            }
        }
    }