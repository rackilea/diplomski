public String accessTkn (String code)
 {
     try {

         HttpClient httpclient = HttpClients.createDefault();
         HttpPost httppost = new HttpPost("https://api.instagram.com/oauth/access_token");

         // Request parameters and other properties.
         List<NameValuePair> params = new ArrayList<NameValuePair>(2);
         params.add(new BasicNameValuePair("client_id", Constants.CLIENT_ID));
         params.add(new BasicNameValuePair("client_secret", Constants.CLIENT_SECRET));
         params.add(new BasicNameValuePair("grant_type", "authorization_code"));
         params.add(new BasicNameValuePair("redirect_uri",  Constants.REDIRECT_URI_AUTH));
         params.add(new BasicNameValuePair("code",  code));


         httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

         //Execute and get the response.
         HttpResponse response = httpclient.execute(httppost);
         HttpEntity entity = response.getEntity();
         System.out.println("entity "+ entity.getContent());

         if (entity != null) {
             InputStream instream = entity.getContent();
             try {

                return (getStringfromStream(instream));
                 // do something useful
             } finally {
                 instream.close();
             }
         }
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (ClientProtocolException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (UnsupportedOperationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return "Abhay";

 }