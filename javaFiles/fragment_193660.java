public class eventupdate extends AsyncTask<String, Void, String>

 @Override
 protected void onPostExecute(String result) {
        super.onPostExecute(result);
         eventText.setText("" + result);
}

 @Override
    protected String doInBackground(String... url) {
   // do your work
   return HTML;