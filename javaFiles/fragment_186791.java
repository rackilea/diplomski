private class DownloadFilesTask extends AsyncTask<URL, Integer, Long> {
     protected Long doInBackground(URL... urls) {
         // TODO do actual download 

         // publish your download progress
         publishProgress(count);

         return null; // TODO insert your result 
     }

     protected void onProgressUpdate(Integer... progress) {
         // TODO set progress to progressbar
         // update UI
     }

     protected void onPostExecute(Long result) {
         // called when download is complete
         // update UI
     }
}