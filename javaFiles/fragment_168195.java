String url = "http://example.com";
String charset = "UTF-8";
String param1 = "value1";
 String param2 = "value2";
// ...
 String query = String.format("param1=%s&param2=%s", 
 URLEncoder.encode(param1, charset), 
 URLEncoder.encode(param2, charset));