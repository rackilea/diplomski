String urlParameters = "myVariable1=myValue1&myVariable2=myValue2";

HttpURLConnection connection = null;  
try {
  url = new URL(targetURL);
  connection = (HttpURLConnection)url.openConnection();

  // Use post and add the type of post data as URLENCODED
  connection.setRequestMethod("POST");
  connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");

  // Optinally add the language and the data content
  connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
  connection.setRequestProperty("Content-Language", "en-US");  

  // Set the mode as output and disable cache.
  connection.setUseCaches (false);
  connection.setDoInput(true);
  connection.setDoOutput(true);

  //Send request
  DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
  wr.writeBytes (urlParameters);
  wr.flush ();
  wr.close ();


  // Get Response    
  // Optionally you can get the response of php call.
  InputStream is = connection.getInputStream();
  BufferedReader rd = new BufferedReader(new InputStreamReader(is));
  String line;
  StringBuffer response = new StringBuffer(); 
  while((line = rd.readLine()) != null) {
    response.append(line);
    response.append('\r');
  }
  rd.close();
  return response.toString();