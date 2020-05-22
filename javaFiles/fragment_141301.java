@Override
    protected void onPostExecute(Exception result) {
            dismissProgress();
            numCompletedDownloads++;
            // other stuff..
    }