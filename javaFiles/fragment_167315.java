HttpURLConnection conn = (HttpURLConnection ) url.openConnection();
   conn.setRequestMethod("GET");
   conn.setReadTimeout(10000); // millis
   conn.setConnectTimeout(15000); // millis
   conn.setDoOutput(true);

   conn.connect();
   int response = conn.getResponseCode();
   if (response == HttpStatus.SC_OK) {
       .....