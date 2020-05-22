GetJsonAsync getJson = new GetJsonAsync();
getJson.execute();

private class GetJsonAsync extends AsyncTask <String, Void, String> {

        @Override
        protected void onPreExecute() {
            // Do stuff before the operation
        }

        @Override
        protected String doInBackground(String... params){
            getJSONFromUrl();
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // Do stuff after the operation
        }
    }