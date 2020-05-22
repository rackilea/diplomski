public String getUrlData(String url) {
String xml = null;

final int TIMEOUT_MILLISEC = 5000;  // 5 seconds

HttpParams httpParams = new BasicHttpParams();
HttpConnectionParams.setConnectionTimeout(httpParams, TIMEOUT_MILLISEC);
HttpConnectionParams.setSoTimeout(httpParams, TIMEOUT_MILLISEC);

DefaultHttpClient httpClient = new DefaultHttpClient(httpParams);
HttpPost httpPost = new HttpPost(url);
System.out.println("waiting");
HttpResponse httpResponse;

try {
    // start the timer here

    httpResponse = httpClient.execute(httpPost);
    HttpEntity httpEntity = httpResponse.getEntity();
    xml = EntityUtils.toString(httpEntity);

    // check if the timer has exceeded by "if else"
    // move to "return xml;" Manually when exceeds 5sec, but how?

} catch (ClientProtocolException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}
return xml;

}