private class MyTask extends AsyncTask<Void, Void, Void> {
   protected Void doInBackground(Void... param) {
     // This method is running off the UI thread.
     // Safe to stop execution here.

     return null;
   }

   protected void onProgressUpdate(Void... progress) {
     // This methid is running on the UI thread. 
     // Do not stop thread here, but safe to modify the UI.
   }

   protected void onPostExecute(Long result) {
     // Also on UI thread, executed once doInBackground()
     // finishes.
   }
 }