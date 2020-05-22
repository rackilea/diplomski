/** This method runs on another thread than the UI thread */
@Override
protected String doInBackground(String... _params) {
    for (int progressValue = 0; progressValue  < 100; progressValue++) {
        publishProgress(progressValue);
    }
}

/** This method runs on the UI thread */
@Override
protected void onProgressUpdate(Integer... progressValue) {
    // TODO Update your ProgressBar here
}

/**
 * Called after doInBackground() method
 * This method runs on the UI thread
 */
@Override
protected void onPostExecute(Boolean _result) {
   // TODO Update the UI thread with the final result
}