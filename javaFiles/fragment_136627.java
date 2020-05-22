private String getPage(String url) {
    HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
    con.connect();

    if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
        return inputStreamToString(con.getInputStream());
    } else {
        return null;
    }
}

private String inputStreamToString(InputStream in) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
    StringBuilder stringBuilder = new StringBuilder();
    String line = null;

    while ((line = bufferedReader.readLine()) != null) {
        stringBuilder.append(line + "\n");
    }

    bufferedReader.close();
    return stringBuilder.toString();
}