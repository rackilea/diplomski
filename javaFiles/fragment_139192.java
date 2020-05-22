class CreateUser extends AsyncTask<String, Void, String> {

         /**
         * Before starting background thread Show Progress Dialog
         * */
        boolean failure = false;

    ProgressDialog pDialog ;
        Context _context;




        public CreateUser(Register activity) {
                _context = activity;       // Create a constructor to initialize the `_context`
            }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
           pDialog = new ProgressDialog(_context);

           pDialog.setMessage("Creating User...");
            pDialog.setIndeterminate(true);
            pDialog.setTitle("Processing");
            pDialog.setCancelable(false);
            pDialog.show();
        }



        @Override
        protected String doInBackground(String... args) {
            // TODO Auto-generated method stub
             // Check for success tag
            int success;

            try {
                // Building Parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("username1",args[0])); // put the values sent from activity i.e username and password.
                params.add(new BasicNameValuePair("password1", args[1]));

                Log.d("request!", "starting");

                //Posting user data to script
                JSONObject json = jsonParser.makeHttpRequest(
                       LOGIN_URL, "POST", params);

                // full json response
                Log.d("Login attempt", json.toString());

                // json success element
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("User Created!", json.toString());
                    finish();
                    return json.getString(TAG_MESSAGE);
                }else{
                    Log.d("Login Failure!", json.getString(TAG_MESSAGE));
                    return json.getString(TAG_MESSAGE);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;

        }
        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            if (pDialog.isShowing())
                    pDialog.dismiss();
            if (file_url != null){
                Toast.makeText(Register.this, file_url, Toast.LENGTH_LONG).show();
            }

        }

    }

        }