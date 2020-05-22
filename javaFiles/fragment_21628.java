// asynctask method onProgressUpdate was renamed publishProgress => 
//  doInBackground's body is almost untouched.
private void publishProgress(final OnProgressObject... values) {
    uiHandler.post(new Runnable() {
        @Override
        public void run() {
            // move here code previously in the AsyncTask's publishProgress()
        }
    });

}