protected void onPostExecute(String file_url) {

     pDialog.dismiss();

     try {

         if (success == 1) {
             // successfully created product
             Intent i = new Intent(getApplicationContext(), AllJobsActivity.class);
             startActivity(i);

             // closing this screen
             finish();
         } else {
             // failed to create product
         }
     } catch (JSONException e) {
        e.printStackTrace();
     }

}