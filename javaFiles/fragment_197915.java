public class SplashScreen extends Activity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splash_screen);


            new DataFromServer().execute();

        }

        private class DataFromServer extends AsyncTask<Void, String, Void> {

            ProgressDialog progressDialog = null;

            @Override
            protected void onPreExecute() {
            // TODO Auto-generated method stub
            //super.onPreExecute();



            progressDialog = ProgressDialog.show(SplashScreen.this,
                "Loading...",
                "Please wait while Ads are being loaded", true,
                false);

           }

           @Override
           protected Void doInBackground(Void... params) {

            /* fetch the data from server here and set the titles variables of the
                           MainActivity */
            // e.g 
            MainActivity.tab1_title = some_data_from_server;
            MainActivity.tab2_title = some_data_from_server;
            MainActivity.tab3_title = some_data_from_server;

        return null;
          }


         @Override
         protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            //super.onPostExecute(result);
            Log.e("tab1: ",MainActivity.tab1_title);
                        Log.e("tab2: ",MainActivity.tab2_title);
                        Log.e("tab3: ",MainActivity.tab3_title);
            Intent intent = new Intent(SplashScreen.this,MainActivity.Class);
            StartActivity(intent);
            SplashScreen.this.finish();

            if (progressDialog != null) { 
            progressDialog.dismiss();
        }
    }

}