Path rootPath = Paths.get("/a/b/");
Files.walk(rootPath)//
     .filter(p -> !p.equals(rootPath))
     .map(Path::toFile)//
     .sorted(Comparator.comparing(File::isDirectory))//
     .forEach(File::delete);