HttpURLConnection.setFollowRedirects(false);
HttpURLConnection con =
    (HttpURLConnection) new URL(urlpath).openConnection();
con.setUsesCache(false); // Of course.
con.setRequestMethod("HEAD");
boolean isOnAir = con.getResponseCode() == HttpURLConnection.HTTP_OK;
con.disconnect();