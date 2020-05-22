HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost("http://127.0.0.1/oauth2/token");
    try {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("grant_type", "password"));
        nameValuePairs.add(new BasicNameValuePair("username", username));
        nameValuePairs.add(new BasicNameValuePair("password", password));
        nameValuePairs.add(new BasicNameValuePair("client_id", clientID));
        nameValuePairs.add(new BasicNameValuePair("client_secret", clientSecret));
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        // Execute HTTP Post Request
        HttpResponse response = httpclient.execute(httppost);

        JSONObject json_auth = new JSONObject(EntityUtils.toString(response.getEntity()));
        String token = json_auth.getString("access_token");

    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (JSONException e) {
        e.printStackTrace();
    }