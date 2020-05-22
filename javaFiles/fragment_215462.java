for (int i = 0; i < fileNames.length; i++){
    String file = fileNames[i];
    String url = path + file;                 
    try {
        urls[i] = new URL(url);
    } catch (MalformedUrlException e) {
        throw new IllegalStateException("Wrong URL: " + url);
    }
}