URLConnection connection = new URL("your url").openConnection();
connection.addRequestProperty("http.proxyHost", "proxy server");
connection.addRequestProperty("http.proxyPort", "proxy port");

// Alternative:
System.setProperty("http.proxyHost", "yourproxyserver");
System.setProperty("http.proxyPort", "portnumber");

InputStream responseStream = connection.getInputStream();

// Read response into buffer and parse it with jsoup