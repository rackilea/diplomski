Map<String, String> env = new HashMap<>();
    env.put("create", "true");
    // locate file system by using the syntax 
    // defined in java.net.JarURLConnection
    URI uri = URI.create("jar:file:/"+zipPath+".zip");

    try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
        java.nio.file.Path externalTxtFile;
        java.nio.file.Path pathInZipfile ;

        externalTxtFile = Paths.get(gamesPath);
        pathInZipfile = zipfs.getPath("/file.txt");
        Files.copy(externalTxtFile, pathInZipfile,
                StandardCopyOption.REPLACE_EXISTING);
        }