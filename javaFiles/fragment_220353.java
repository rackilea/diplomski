File appDir = new File(System.getProperty("user.dir"));
    URI uri = new URI(appDir.toURI()+"/songs/BrokenAngel.mp3");
    // just to check if the file exists
    File file = new File(uri);
    System.out.println(file.exists())
    URL song1Url = uri.toURL();