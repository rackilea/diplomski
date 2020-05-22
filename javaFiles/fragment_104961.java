public String getXML() throws Exception
{
  StringBuilder builder = new StringBuilder();
  HttpClient httpclient = new DefaultHttpClient();
  HttpGet httpget = new HttpGet("myscript.php");
  HttpResponse response = httpclient.execute(httpget);
  int statuscode = response.getStatusLine().getStatusCode();
  if(statuscode == 200)
  {
    HttpEntity entity = response.getEntity();
    InputStream content = entity.getContent();
    BufferedReader reader = new BufferedReader(new InputStreamReader(content));
    String line;
    while ((line = reader.readLine()) != null)  builder.append(line);               
  }
  else throw new Exception("HTTP error: " + String.valueOf(statuscode));
  return builder.toString();
}