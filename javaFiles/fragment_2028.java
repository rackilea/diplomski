private class SomeTask extends AsyncTask<String, String, String> {
    @Override
        protected String doInBackground(String... params) {
         while(condition) {
         //do more
         publishProgress("Some text value to you textview");
        }
         return null;
     }

     @Override
     protected void onProgressUpdate(String... values) {
         txtProgreso.append(values[0]);
     }


 }