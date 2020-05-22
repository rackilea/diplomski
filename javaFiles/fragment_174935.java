private class HttpTask extends AsyncTask<String, Void, Void>{
    @Override
    protected Void doInBackground(String... params) {
        String url = params[0];
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        ResponseHandler<String> resHandler = new BasicResponseHandler();
        try {
            String page = httpClient.execute(httpGet, resHandler);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        Toast.makeText(getApplicationContext(), "SUCCESS", 2000).show();
    }
}