// create the url object and open the connection
URL url = new URL("http://somewhere.com");
HttpURLConnection conn = (HttpURLConnection) url.openConnection();

// read the webpage  a line at a time and append it to a `StringBuilder`
BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
String line;
StringBuilder sb = new StringBuilder();
while ((line = br.readLine()) != null) {
    sb.append(line);
}
// here is the html
String html = sb.toString();