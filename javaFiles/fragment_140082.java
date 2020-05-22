DefaultHttpClient httpclient = new DefaultHttpClient();
HttpGet httpGet = new HttpGet("http://www.spiegel.de");

try
{
  HttpResponse response = httpclient.execute(httpGet);
  HttpEntity entity = response.getEntity();
  if (entity != null)
  {
    System.out.println(EntityUtils.toString(entity));
  }
}
catch (ClientProtocolException e) {e.printStackTrace();}
catch (IOException e) {e.printStackTrace();}