FileSystem fs = FileSystems.getFileSystem(URI.create("jrt:/"));

Files
    .list(fs.getPath("modules", "java.base", "java/lang"))
    .map(Path::getFileName)
    .filter(p -> p.toString().endsWith(".class") && !p.toString().contains("$"))
    .forEach(System.out::println);