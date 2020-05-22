@Override
protected Void doInBackground(Void... params) {

    try {
        DefaultHttpClient httpclient = new DefaultHttpClient();

        String user = "user@gmail.com";
        String pass = "password";
        String source = "Cloud%20Printing%20Test";

        HttpGet authGet = new HttpGet(
                "https://www.google.com/accounts/ClientLogin?accountType=HOSTED_OR_GOOGLE&Email="
                        + user
                        + "&Passwd="
                        + pass
                        + "&service=cloudprint&source=" + source);

        HttpResponse httpResponse;

        httpResponse = httpclient.execute(authGet);

        String authResponse = EntityUtils
                .toString(httpResponse.getEntity());
        String authKey = authResponse.substring(authResponse
                .indexOf("Auth=") + 5);
        authKey = authKey.replace("\n", "");

        MyLog.d(TAG, "Auth key: " + authKey);

        HttpPost printPost = new HttpPost(
                "https://www.google.com/cloudprint/submit?output=json");
        printPost.setHeader("Authorization", "GoogleLogin auth=" + authKey);
        printPost.setHeader("X-CloudPrint-Proxy", source);

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("printerid", "ID"));
        nameValuePairs.add(new BasicNameValuePair("title", "TEST"));
        nameValuePairs.add(new BasicNameValuePair("capabilities", "{capabilities=[]}"));
        nameValuePairs.add(new BasicNameValuePair("content", "123"));
        nameValuePairs.add(new BasicNameValuePair("contentType", "text/plain"));
        printPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        HttpResponse printResponse = httpclient.execute(printPost);
        String lol = EntityUtils.toString(printResponse.getEntity());

    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}