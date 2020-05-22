private class CheckUsernameFromUrlTask extends AsyncTask<URL, Integer, String> {
     protected String doInBackground(URL... urlToGetTheUsername) {
         String usernameFromHttpGetMethod = null;
         // code to make (similar to your checkCurrentWinner method)
         //   1. HTTP GET request
         //   2. Extract username (incl. error handling)
         return usernameFromHttpGetMethod;
     }

     protected void onProgressUpdate(Integer... progress) {
         // ignore for now, unless you want to show the progress blocking UI
     }

     protected void onPostExecute(String result) {
         // back in the UI thread. Perform all view operations
         // Handle exceptions by saving the exception thrown in 
         // doInBackground method as an instance variable of this class or
         // changing the return object to be a custom object containing
         // username and exception.
         String labelText = result == null ? "Not Found!" : result;
         currentWinnerLabel.setText(labelText );
     }
 }