public Optional<URL> getAuthenticatedURL() throws MalformedURLException {
    if (log != null){
        log.writeINFOToLog("Fetching authentication URL...");
    }
    else{
        Log.initLog();
        log.writeINFOToLog("Fetching authentication URL...");
    }
    String url = String.format("%s://%s%s?username=%s&password=%s",getProtocol(), getHost(), getPath(), getUsername(), getPassword());
    return Optional.ofNullable(new URL(url));
}