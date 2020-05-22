public class RegisterTask extends AsyncTask<Map, Void, Boolean> {

    @Override
    protected Boolean doInBackground(Map... params) {
        Map props = params[0];  // you can access your request params here

        /*
         Do your network request here, using HttpUrlConnection or 
         HttpClient. and return a result (boolean in this example),
         which is passed to the onPostExecute method
        */
        return false;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        // This method is run on the main thread, so you can
        // update your UI after the request is completed.
    }
}