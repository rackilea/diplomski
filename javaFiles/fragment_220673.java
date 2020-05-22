URL url = new URL("http://some-server");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();
conn.setRequestMethod("POST");

// read the response
System.out.println("Response Code: " + conn.getResponseCode());
InputStream in = new BufferedInputStream(conn.getInputStream());
String response = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
System.out.println(response);