new AsyncTask<String, String, String> {
    protected String doInBackground(String... params) {

        // code to do network activity

        return result;
    }
    protected void onPostExecute(String result) {

        // code to do after the procedure is finished

    }    
    protected void onPreExecute() {

        // code to do before the procedure starts

    }
}.execute([params]);