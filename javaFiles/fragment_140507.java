(new AsyncTask<Void, Void, String>() {
        @Override
        protected String doInBackground(Void... params) {
      String result = "";
            try {

                String requestString = "https://api-eu.clusterpoint.com/908/users/";

                HttpClient httpClient = new DefaultHttpClient();
                HttpGet httpget = new HttpGet(requestString);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();

                httpget.addHeader("Authorization", "Basic "+Base64.encodeToString
                        ("username:password".getBytes(),Base64.NO_WRAP));

                result = httpClient.execute(httpget, responseHandler);
            } catch (IOException e) {
                result = e.toString();
                e.printStackTrace();
            } finally {
                Log.v("ClusterResponse", "Done");
                return result;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getBaseContext(), s, Toast.LENGTH_LONG).show();
            Log.v("ClusterResponse", s);
        }
    }).execute();