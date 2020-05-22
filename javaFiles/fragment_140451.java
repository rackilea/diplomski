extends AsyncTask<String, String, String>

@Override
protected void onPostExecute(String result) {
    //heare result is value you return from doInBackground() method 
    //this is work on UI thread
}