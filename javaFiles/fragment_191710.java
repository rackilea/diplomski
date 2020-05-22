URL url = new URL(path);
HttpURLConnection connection = (HttpURLConnection)  url.openConnection();
connection.setRequestProperty("User-Agent", "Not a Java Bot");
connection.setRequestMethod("HEAD");
connection.connect();
return connection.getContentType();