Path outer = Paths.get("C:", "test-1.0-SNAPSHOT.jar");
ClassLoader cl = null;
try(FileSystem outerFs = FileSystems.newFileSystem(outer, cl);
    FileSystem innerFs = FileSystems.newFileSystem(
        outerFs.getPath("/BOOT-INF/lib/core-1.0-SNAPSHOT.jar"), cl) ) {

    Path p = innerFs.getPath("images");
    Files.walk(p).forEach(path -> System.out.println(path));
}