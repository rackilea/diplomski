private class DownloadFilesTask extends AsyncTask<Void, Void, Void> {
     protected Void doInBackground() {             
         ...
         return;
     }

     protected void onProgressUpdate() {
         setProgressPercent("hi");
     }

     protected void onPostExecute() {
         showDialog("bye");
     }
 }