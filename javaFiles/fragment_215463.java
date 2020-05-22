for (int i = 0; i < fileNames.length; i++){
    try {
        urls[i] = new URL(path + fileNames[i]);
    } catch (MalformedUrlException e) {
        throw new IllegalStateException("Wrong URL: " + path + fileNames[i]);
    }
}