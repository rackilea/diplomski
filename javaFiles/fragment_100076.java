String xmlString;
HttpURLConnection urlConnection = null;
URL url = new URL("http://example.com");
String userName = "test";
String password = "password";
try {
    urlConnection = (HttpURLConnection)url.openConnection();
    // set authentication
    String userCredentials = userName+":"+password;
    String basicAuth = "Basic " + new String(Base64.encode(userCredentials.getBytes(), Base64.DEFAULT));
    urlConnection.setRequestProperty("Authorization", basicAuth.trim());
    // set request method
    urlConnection.setRequestMethod("GET");
    if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
        StringBuilder xmlResponse = new StringBuilder();
        BufferedReader input = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()), 8192);
        String strLine = null;
        while ((strLine = input.readLine()) != null) {
             xmlResponse.append(strLine);
        }
        xmlString = xmlResponse.toString();                
        input.close();
    }
  }
  catch (Exception e) {// do something

  }
  finally {// close connection
    if (urlConnection != null) {
        urlConnection.disconnect();
      }
 }