DefaultHttpClient client = new DefaultHttpClient();
HttpGet httpGet = new HttpGet(url);
httpGet.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_3) AppleWebKit/536.28.10 (KHTML, like Gecko) Version/6.0.3 Safari/536.28.10");
httpGet.setHeader("Accept-Language", "en");
try {
  HttpResponse execute = client.execute(httpGet);
  InputStream content = execute.getEntity().getContent();

  BufferedReader buffer = new BufferedReader(new InputStreamReader(content));
  String s = "";
  while ((s = buffer.readLine()) != null) {
    builder.append(s);
  }

} catch (Exception e) {
  e.printStackTrace();
}