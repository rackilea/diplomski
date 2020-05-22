class MyAsyncTask extends AsyncTask<Object, Object, JSONObject> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //Show progress loader to user
    }

    @Override
    protected JSONObject doInBackground(Object... params) {
        //Logic to call 1st API - This is HTTP call
        String MovieId = fetchMovieDetails();

        //Pass above MovieId in next API call - This is also HTTP call
        JSONObject jsonObject = fetchGenres(MovieId);

        return jsonObject;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
        //Parse this jsonObject and process further
    }
}