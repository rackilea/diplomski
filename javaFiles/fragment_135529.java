private class LongOperation extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
       //do your http request here

        return result;//what you got from server
    }

    @Override
    protected void onPostExecute(String result) {

 //process your result and update ui here
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onProgressUpdate(Void... values) {
    }
}