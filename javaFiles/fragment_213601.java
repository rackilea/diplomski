// Initial download.
String lastModified = connection.getHeaderField("Last-Modified");

// ...

// Resume download.
connection.setRequestProperty("If-Range", lastModified);