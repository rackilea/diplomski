public void blah(String[] args) {
   new AsyncTask<Void, Void, Void>() {

        @Override
        protected void onPreExecute()
        {
            // here is for code you do before the network call. you 
            // leave it empty
        }

        @Override
        protected Void doInBackground(Void... params)
        {
            // here goes your network call
            HttpClient httpClient = new DefaultHttpClient();
            HttpContext localContext = new BasicHttpContext();
            HttpGet httpGet = new HttpGet("http://9.42.68.71:8080/resources/dashboard?dashboard=rack");
            String text = null;
            try {
                  HttpResponse response = httpClient.execute(httpGet, localContext);
                  HttpEntity entity = response.getEntity();
                  text = getASCIIContentFromEntity(entity);
            } catch (Exception e) {
            }
            System.out.println(text);
        }

        @Override
        protected void onPostExecute(Void res)
        {
            // here goes your UI code. i.e if you want to hide a button
        }
    }.execute();
}