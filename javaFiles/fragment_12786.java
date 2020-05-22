public class MapActivity extends FragmentActivity {


    boolean areTasksComplete = false;
    //call this when last task is complete
    public void afterAllTasksComplete(List<List<HashMap<String, String>>> result) {
        areTasksComplete = true;
        dists.add(result);

    }

    private class DownloadTask extends AsyncTask<String, Void, String>
    {
        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url){}

        // Executes in UI thread, after the execution of doInBackground()
        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);
            parserTask.execute(result);
        }
    }

    /** A class to parse the Google Places in JSON format */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>>{
      // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData){
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result){

            afterAllTasksComplete(result);
        }
    }
    /**
     * Background Async Task to Load all product by making HTTP Request
     * */
    class LoadAllProducts extends AsyncTask<String, String, String> {

        //.....//

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String result) {
             for(int i; i < 3; i++){
                downloadTask = new DownloadTask();
                downloadTask.execute(result);
            }
        }
    }

}