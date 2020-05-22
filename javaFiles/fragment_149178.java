File f;
try {
    f = new File(url.toURI());
} catch(URISyntaxException e) {
    f = new File(url.getPath());
}