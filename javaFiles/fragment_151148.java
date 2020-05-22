Path confDir = Paths.get("/test1/test2/test3");
    Files.createDirectories(confDir);
    Path confFile = confDir.resolve("filename.properties");

    if (Files.exists(confFile))
        try (InputStream in = Files.newInputStream(confFile)) {
            // Use the InputStream...
        }
    else
        Files.createFile(confFile);