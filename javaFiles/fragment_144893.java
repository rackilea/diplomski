new AsyncTask<String,String,String>(){

@Override
protected String doInBackground(String... params) {

    //Your HTTP Request goes here

    return response;
}

@Override
protected void onPostExecute(String s) {
    super.onPostExecute(s);
    Log.i("UpdateJSON ", s);
    if(!s.equalsIgnoreCase("null") || !s.equalsIgnoreCase(""))
        writeManifestJSON(s);
}
}.execute();