public static void main(String[] args) throws Exception {

  URL url = new URL("http://www.targetdomain.com/api?key1=value1&key2=value2...");

  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
  conn.setConnectTimeout(5000);    // 5 seconds
  conn.setRequestMethod("GET");       
  conn.connect();
  BufferedReader rd  = new BufferedReader(new InputStreamReader(conn.getInputStream()));

  String line;
  StringBuffer bf = new StringBuffer();
  while ((line = rd.readLine()) != null) {
      bf.append(line);
  }
  conn.disconnect(); 

  //... pass bf to an XML parser and do your processing...
}