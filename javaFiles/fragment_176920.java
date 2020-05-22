private class WorkerTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        //Network calls go here. This will be done in the background, 
        //in a separate thread

        //Finally, you return your result here to onPostExecute
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        //This method runs on the main UI thread. Here you update your UI o return data to your caller class.
    }

    @Override
    protected void onPreExecute() {
        //Called before execution
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        //If you want to update your UI with your current progress, that code goes here
    }
}