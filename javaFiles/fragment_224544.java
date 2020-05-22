public void postData() {
    HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost("http://www.yoursite.com/yourscript.php");

    try {

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("id", "123"));
        nameValuePairs.add(new BasicNameValuePair("string", "Hey"));
        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        // Execute HTTP Post Request
        HttpResponse response = httpclient.execute(httppost);

    } catch (ClientProtocolException e) {
        // Catch Protocol Exception
    } catch (IOException e) {
        // Catch IOException
    }
}