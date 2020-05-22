URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
    try {
        URI uri = new URI(url.toString() + "/myDir");
        Path path  = Paths.get(uri);
        if(!Files.exists(path)){
            Files.createDirectory(path);
        }
    } catch (URISyntaxException e) {
        throw new RuntimeException(e);
    }