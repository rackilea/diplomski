final int MAX_DEPTH = 50;  // Max depth of subdirectories to search
Path userDir = Paths.get(System.getProperty("user.dir"));
System.out.println(userDir);
String archivoLiga="LigaV2";
System.out.println(
        Files.find(
                userDir,
                maxDepth,
                (path,attr) -> path.getFileName().startsWith(archivoLiga)
                        && path.getFileName().endsWith(".properties"))
        .findAny()
        .isPresent());