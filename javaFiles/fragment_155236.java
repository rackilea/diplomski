public static boolean isAccessable(String url, int timeout) {
    url = url.replaceFirst("https", "http"); // Otherwise an exception may
                                                // be thrown on invalid SSL
                                                // certificates.

    try {
        HttpURLConnection connection = (HttpURLConnection) new URL(url)
                .openConnection();
        connection.setConnectTimeout(timeout);
        connection.setReadTimeout(timeout);
        connection.setRequestMethod("HEAD");
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            return false;
        }
    } catch (IOException exception) {
        return false;
    }
    return true;
}