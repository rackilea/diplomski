URL url = new URL("http://user:pass@domain.com/url");
URLConnection urlConnection = url.openConnection();

if (url.getUserInfo() != null) {
    String basicAuth = "Basic " + new String(new Base64().encode   (url.getUserInfo().getBytes()));
    urlConnection.setRequestProperty("Authorization", basicAuth);
}

InputStream inputStream = urlConnection.getInputStream();