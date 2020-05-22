Pattern p = Pattern.compile("\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
if (!p.matcher(url).matches() &&
        (p.matcher("https://" + url).matches()) {
    url = "https://" + url;
    // load the url
}