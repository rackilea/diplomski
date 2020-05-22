String str_path = "C:\\reports\\errors\\";
Path dir = Paths.get(str_path);
if (Files.notExists(dir)) {
    dir = Files.createDirectory(dir);
}
Path errorFile = dir.resolve(fielname + ".txt");
Files.deleteIfExists(errorFile);
Files.createFile(errorFile);