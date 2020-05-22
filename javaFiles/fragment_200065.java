ArrayList<NameValuePair> projectLoginInfo = new ArrayList<NameValuePair>();
    projectLoginInfo.add(new BasicNameValuePair("username", userNameValue));
    projectLoginInfo.add(new BasicNameValuePair("password", passwordValue));
     HttpPost httppost = new HttpPost("http://www.sample.url");

     try{      //encode login data and Hands the entity to the request.
        httppost.setEntity(new UrlEncodedFormEntity(projectLoginInfo));
    }
    catch (UnsupportedEncodingException e1)
    {
        e1.printStackTrace();
        Log.e("UnsupportedEncoding", "unable to encode some characters", e1);

        return null;
    }`
          HttpResponse response = client.execute(httppost);
          StatusLine statusLine = response.getStatusLine();