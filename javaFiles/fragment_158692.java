public Map<String, String> bodyToMap(String bodyStr) {
  Map<String, String> body = new HashMap<>();
  String[] values = bodyStr.split("&");
  for (String value : values) {
    String[] pair = value.split("=");
    if (pair.length == 2) {
      body.put(pair[0], pair[1]);
    }
  }
  return body;
}