2. For post mehod as postparam in querystring (query params is again same as get method only)

3. If you want send as postparams use below code 


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

            return -1;
        }`