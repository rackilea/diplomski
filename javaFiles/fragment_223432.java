public void doLogin(final MyCallback callback) {

    new AsyncTask<URL, Void, Boolean> {
        protected Boolean doInBackground(URL... urls) {
            // make network calls to login in this "background" thread.
            loginSuccess = true;
            return loginSuccess;
        }

        protected void onPostExecute(Boolean loginSuccess) {
           callback.onResult(loginSuccess);
        }
    }.execute();
}