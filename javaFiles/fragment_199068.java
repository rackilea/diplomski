try {
    String urlSource = getUrlSource("http://www.google.com");
    //process your url source
} catch (MalformedURLException ex) {
    //your url is wrong, do some stuff here
} catch (IOException ex) {
    //I/O operations were interrupted, do some stuff here
}