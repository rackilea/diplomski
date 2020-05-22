new AsyncTask<String, Void, String>() {

    @Override
    protected Void doInBackground(String str) {
    // Do all the time consuming code here
    return result; //Return your string from here
    }

    @Override
    protected void onPostExecute(String result) {
    setResultValue(result);
    }

}.execute();

private void setResultValue(String value) {
// You get your string here
}