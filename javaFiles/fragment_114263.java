class TheTask extends AsyncTask<String,String,String>
{
    @override
    protected String doInbackground(String... params)
    {
        String _response =null;
        try {
        // defaultHttpClient
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(params[0]);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
         _response=EntityUtils.toString(httpEntity);
        }catch(Exception e)
        {
           e.printStacktrace();
        } 
      return _response;
    }
    @Override
    protected void onPostExecute(String result) {
    // TODO Auto-generated method stub
    super.onPostExecute(result);
    Log.i(".......",result);

}

}