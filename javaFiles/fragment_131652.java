public static void main(String[] args) throws Exception {
    Path zipfile = Paths.get("C:\\Users\\me.user\\Downloads\\myfile.zip");

    try (FileSystem zipfs = FileSystems.newFileSystem(zipfile, null);) {
        Path extFile = Paths.get("C:\\Users\\me.user\\Downloads\\countries.csv"); // from normal file system
        Path directory = zipfs.getPath("/some/directory"); // from zip file system
        Files.createDirectories(directory);
        Files.copy(extFile, directory.resolve("zippedFile.csv"));
    }
}