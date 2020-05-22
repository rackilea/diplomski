private String generateLink(String jobClassCd) {
    String url = XXX_URL + jobClassCd + ".pdf";
    try {
        HttpURLConnection connection =
            (HttpURLConnection) new URL(url).openConnection();

        if (connection.getResponseCode() < 400) {
            return url;
        }
    } catch (IOException e) {
        Logger.getLogger(JobSerializer.class.getName()).log(Level.FINE,
            "URL \"" + url + "\" is not reachable.", e);
    }

    return null;
}