String queryString = "param1=" +
  URLEncoder.encode(param1Value, "UTF-8");
queryString += "&param2=" +
   URLEncoder.encode(param2Value, "UTF-8");

// Make connection

URL url = new URL("http://www.localhost.8080/");
URLConnection urlConnection = url.openConnection();
urlConnection.setDoOutput(true);