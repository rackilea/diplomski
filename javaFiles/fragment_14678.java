public static String HitServerPOST(String url,List<NameValuePair> nameValuePairs) {
    DefaultHttpClient hc = new DefaultHttpClient();
    ResponseHandler<String> res = new BasicResponseHandler();
    HttpPost postMethod = new HttpPost(url);
    String response = null;

    try {
        postMethod.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    try {
        response = hc.execute(postMethod, res);
    } catch (ClientProtocolException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    return response;
}