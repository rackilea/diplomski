private class MyAsyncTask extends AsyncTask<Void, Void, String> {
 protected String doInBackground(Void... params) {
   String answer = WebServiceRequests.About();
   return answer;
 }

 protected void onPostExecute(String answer) {
   // Update UI.
   showDialog("Answer " + answer);
 }