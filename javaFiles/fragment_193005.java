//use String for last parameter here:
 new AsyncTask<Void, Void, String>() {
        ProgressDialog progressDialog;

        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(JobScreen.this);
            progressDialog.setMessage("Getting Items..");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
        //String return value:
        protected String doInBackground(Void... unused) {


            try
            {
                DefaultHttpClient httpClient = new DefaultHttpClient();

                HttpGet post = new HttpGet("http://users.abdullahadhaim.com/users/WebServiceResturant.asmx/login?userName=abood&Password=123");
                HttpResponse response = httpClient.execute(post);
                String responseString = EntityUtils.toString(response.getEntity());
                JSONArray jsonArray = new JSONArray(responseString);

                JSONObject jsonObject = jsonArray.getJSONObject(0);


                Log.e("Done", "Done");

                //return the String you need:
                return jsonObject.getString("UserName");
            }
            catch (Exception e)
            {
                e.printStackTrace();
                //remove this Toast:
                //Toast.makeText(MainActivity.this, "Faild", Toast.LENGTH_SHORT).show();

            }

            return null;

        }
        //String parameter
        protected void onPostExecute(String username) {
            super.onPostExecute(username);

            if (username == null){
                //Toast if username is null
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
            else{
               //Set the text here with the String received:
               ed1.setText(username);
            }    
            progressDialog.dismiss();
        }
    }.execute();