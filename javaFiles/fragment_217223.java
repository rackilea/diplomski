private class YourAsyncTaskClass extends AsyncTask<String, Void, String> {

      @Override
      protected String doInBackground(String... params) {
           //your http network call here.
            return null;
      }      

      @Override
      protected void onPostExecute(String result) {
           //update your ui here
      }

      @Override
      protected void onPreExecute() {
             //do any code before exec
      }

      @Override
      protected void onProgressUpdate(Void... values) {
              //If you want to update a progress bar ..do it here
      }
}