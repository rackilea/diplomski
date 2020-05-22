private class Async extends AsyncTask<Void, Void, String> {

   @Override
   protected String doInBackground(Void... params) {
       String myParamsForUi = getSystemInfo();
       return myParamsForUi;
   }

   @Override
   protected void onPostExecute(String result) {
       super.onPostExecute(result);

       outTASKS.setText("Tasks: " + result);

   }

}