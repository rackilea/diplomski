public void postData(final String email, final String password)
{
    DefaultHttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost(LOGIN_URL);
    client.getParams().setParameter("http.useragent", "Custom Browser");
    client.getParams().setParameter(CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

    try
    {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("email", email));
        nameValuePairs.add(new BasicNameValuePair("password", password));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nameValuePairs, HTTP.UTF_8);
        entity.setContentType("application/x-www-form-urlencoded");
        post.setEntity(entity);

        printHeaders(client.execute(post));
        printCookies(client.getCookieStore());
    }
    catch (ClientProtocolException e)
    {
        LOG.error("ClientProtocolException", e);
    }
    catch (IOException e)
    {
        LOG.error("IOException", e);
    }
}