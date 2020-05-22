HttpClient httpClient = new HttpClient();
  GetMethod getMethod = new GetMethod(); //You could use PostMethod if servlet accept POST

  String request ="http://some-remote-server/some-servlet?param1=value1&param2=value2";
  httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
  getMethod.setURI(new URI(request, false, null));
  ...