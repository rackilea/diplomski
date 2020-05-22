public static HttpClient login(final String username, final String password) 
{
    HttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost(LOGIN_URL);
    client.getParams().setParameter("http.useragent", "Custom Browser");
    client.getParams().setParameter(
             CoreProtocolPNames.PROTOCOL_VERSION, HttpVersion.HTTP_1_1);

    try 
    {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
        nameValuePairs.add(new BasicNameValuePair("user", username));
        nameValuePairs.add(new BasicNameValuePair("passwd", password));
        UrlEncodedFormEntity entity = 
              new UrlEncodedFormEntity(nameValuePairs, HTTP.UTF_8);
        entity.setContentType("application/x-www-form-urlencoded");

        post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        HttpResponse response = client.execute(post);

        BufferedReader reader = 
              new BufferedReader(
              new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        while ((line = reader.readLine()) != null) 
        {
            System.out.println(line);
        }
    } 
    catch (Throwable e) { e.printStackTrace(); }
    return client;
}

public static void getProfile(HttpClient client) 
{
    HttpGet get = new HttpGet(PROFILE_URL);
    HttpResponse response;
    try 
    {
        response = client.execute(get);
        BufferedReader reader = 
               new BufferedReader(
               new InputStreamReader(response.getEntity().getContent()));

        String line = "";
        while ((line = reader.readLine()) != null) 
        {
            System.out.println(line);
        }
    } 
    catch (ClientProtocolException e) { e.printStackTrace(); } 
    catch (IOException e) { e.printStackTrace(); }  
}