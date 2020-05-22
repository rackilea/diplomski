String finalURL(String url) {
    HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
    con.setInstanceFollowRedirects(false);
    con.connect();
    return con.getHeaderField("Location").toString();
}