URL url;
if (feedLocation.startsWith("http")) {
    url = new URL(feedLocation);
    URLConnection urlConnection = url.openConnection();
    // Check for HTTP 301 redirect
    String redirect = urlConnection.getHeaderField("Location");
    if (redirect != null) {
        logger.log(Level.WARNING, "Redirecting to " + redirect);
        url = new URL(redirect);
    }
} else {...