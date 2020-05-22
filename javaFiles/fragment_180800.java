private void getHTTPConnection() 
{
    try
    {
        mAccessToken = mFacebook.getAccessToken();
        HttpClient httpclient = new DefaultHttpClient();
        String result = null;
        HttpGet httpget = new HttpGet("https://graph.facebook.com/me/friends?access_token="+ mAccessToken + "&fields=id,first_name,last_name,location,picture");
        HttpResponse response;
        response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        if (entity != null) 
        {
            result = EntityUtils.toString(entity);
            parseJSON(result);
        }
    }
    catch (Exception e) 
    {
        e.printStackTrace();
    }
}