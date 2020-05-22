public static Path createBackup(Path file) throws IOException {
    Path backup = file.resolveSibling(file.getFileName().toString()+".BAK");
    return Files.copy(file, backup, StandardCopyOption.REPLACE_EXISTING);
}
public static void main(String... args) {
    try(FileSystem fs = FileSystems.newFileSystem(Paths.get("a.zip"), null)) {
       Path f = fs.getPath("file.bin");
       Path backup = createBackup(f);

       System.out.println(Files.exists(backup)); // prints "true"
       System.out.println(new String(Files.readAllBytes(backup))); // prints its bytes
       System.out.println(backup.toString()); // prints "file.bin.BAK"
    } catch (IOException ex) {
       System.err.println(ex);
    }
}