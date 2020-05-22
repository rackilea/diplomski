private class MyTask extends AsyncTask<Void, Integer, Void> { 

    protected Void doInBackground(Void... params) {
        // Add the long running calculations in here...
        // If you want, you can make periodic calls to the UI thread,
        // by using the publishProgress() method, for example:
        for (int x = 0 ; x < 10 ; x++) {
            publishProgress(x);
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        // This method will be called everytime you call publishProgress().
        // Everything within this method will be called on the UI thread.
        // You can delete this method if you don't want to use it.
    }

    protected void onPostExecute(Void results) {
        // Anything you put in here will be called on the UI thread,
        // once doInBackground has finished
    }
}