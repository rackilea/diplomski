class doProcess extends AsyncTask<Void, Void, String> {

        private Context mcontext;
        private String urlToPost;

        public doProcess(Context mcontext, String urlToPost) {
            this.mcontext = mcontext;
            this.urlToPost = urlToPost;
        }

        @Override
        protected String doInBackground(Void... params) {
            String responseString = "";


            try {

                DefaultHttpClient client = new DefaultHttpClient();
                HttpPost getRequest = new HttpPost(urlToPost);
                HttpResponse getResponse = client.execute(getRequest);

                final int statusCode = getResponse.getStatusLine().getStatusCode();
                //200
                if (statusCode != HttpStatus.SC_OK) {

                    return null;

                }
                HttpPost post = new HttpPost(urlToPost);

                StringEntity se = new StringEntity("", "UTF-8");

                se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));


                responseString = EntityUtils.toString(getResponse.getEntity());


            } catch (Exception e) {
                responseString = e.toString();
                e.printStackTrace();
            }

            return responseString;

        }

        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);

            if (aVoid.isEmpty()) {

            } else {
                UtilityFunctions.getFunctions().makeToast(mcontext, Html.fromHtml(aVoid.toString()).toString());
            }

     }
    }