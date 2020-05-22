private class HttpRequestTask extends AsyncTask<URL, Integer, String> {

      public void setOnResultsListener(ResultsListener listener) {
           this.listener = listener;
      }

      protected String doInBackground(URL... urls) {
         int count = urls.length;
         for (int i = 0; i < count; i++) {
             String httpResult = // Do your HTTP requests here
             // Escape early if cancel() is called
             if (isCancelled()) break;
         }
         return httpResult;
     }

     // use this method if you need to show the progress (eg. in a progress bar in your UI)
     protected void onProgressUpdate(Integer... progress) {
         setProgressPercent(progress[0]);
     }
     // this method is called after the download finished.
     protected void onPostExecute(String result) {
         showDialog("Downloaded " + result);
         listener.onResultsSucceded(result);
     }
 }