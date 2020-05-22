private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {

         // Show image Here
        }
        @Override
        protected String doInBackground(String... params) {
             String xml = null;

        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet HttpGet = new HttpGet(url);

            HttpResponse httpResponse = httpClient.execute(HttpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            xml = EntityUtils.toString(httpEntity,"UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return null;
        }





        @Override
        protected void onPostExecute(String result) {
        /Handle Result From server
        }


        @Override
        protected void onProgressUpdate(Void... values) {
        }