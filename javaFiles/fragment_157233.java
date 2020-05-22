public void test() throws ClientProtocolException,IOException{

    HttpGet httpGet = new HttpGet(urlStr);
    HttpClient httpclient = new DefaultHttpClient();
    HttpResponse httpResponse = httpclient.execute(httpGet);

}