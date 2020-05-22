private class TwitchAsync extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... params) {
        String str = twitch.getJson("streams");
        return str;
    }

    @Override
    protected void onPostExecute(String result){
        Toast.makeText(MainActivity.this, "result: " + result, Toast.LENGTH_LONG).show();

        //testing buildJSON:
        JSONObject obj = twitch.buildJSON(result);

        Log.d("JSON Result: ",  obj.toString());
    }
}