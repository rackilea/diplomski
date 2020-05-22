//Set the http proxy to webcache.mydomain.com:8080

System.setProperty("http.proxyHost", "webcache.mydomain.com");
System.setPropery("http.proxyPort", "8080");

// Next connection will be through proxy.
URL url = new URL("http://java.sun.com/");
InputStream in = url.openStream();

// Now, let's 'unset' the proxy.
System.setProperty("http.proxyHost", null);

// From now on http connections will be done directly.