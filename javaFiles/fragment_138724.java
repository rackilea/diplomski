URI uri = URI.create("jar:file:/D:/devel/somejar.jar!/foo/Bar.class");

String[] array = uri.toString().split("!");
String jarFile = array[0];
String entryPath = array[1];
try(FileSystem fs = FileSystems.newFileSystem(URI.create(jarFile), new HashMap<>())) {
    Path path = fs.getPath(entryPath);
    URI parentUri = path.getParent().toUri();
    ...
}