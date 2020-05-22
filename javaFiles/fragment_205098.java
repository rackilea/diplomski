class GetStuffAsyncly extends AsyncTask<String, String, String> {
   //What ever variables, you needed



    @Override
    protected String doInBackground(String... args) {
        // do stuff in background...
        //When you want to update something in the middle use the below method
        publishProgress(Value);    
        return args[0];
    }

    /**
     * After completing background task Dismiss the progress dialog
     **/
    protected void onPostExecute(String jsonString) {
       //Here the thread execution ends.

    }
    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
       //Here you will get the value what you want to update while running the thread.
    }
}