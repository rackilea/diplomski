public String getHostName(String url) {
    URI uri = new URI(url);
    String hostname = uri.getHost();
    // to provide faultproof result, check if not null then return only hostname, without www.
    if (hostname != null) {
        return hostname.startsWith("www.") ? hostname.substring(4) : hostname;
    }
    return hostname;
}