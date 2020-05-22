private class MyAsyncTask extends AsyncTask<String, HttpResponse, HttpResponse>{

        @Override
        protected HttpResponse doInBackground(String... params) {
            // TODO Auto-generated method stub
            return postData(params[0]);
        }

        protected void onPostExecute(HttpResponse result){
            View pb;
            pb.setVisibility(View.GONE);

            HttpEntity entity = result.getEntity();
            String responseString = EntityUtils.toString(entity, "UTF-8");
            Toast.makeText(mContext, responseString, Toast.LENGTH_LONG).show();
        }

        @SuppressWarnings("unchecked")
        public HttpResponse postData(String valueIWantToSend) {
            // Create a new HttpClient and Post Header
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("__url_to_file.php");

            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("myHttpData", valueIWantToSend));
            httppost.setEntity(new UrlEncodedFormEntity((List<? extends org.apache.http.NameValuePair>) nameValuePairs));

            HttpResponse response = httpclient.execute(httppost);
            return response;
        }

    }