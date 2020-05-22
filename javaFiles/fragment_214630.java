Path dir = Paths.get("C:/Users/PC/Desktop/");

public void TravelToFantasy(Path dir)
throws IOException {
    try (DirectoryStream<Path> listFile = Files.newDirectoryStream(dir)) {
        for (Path file : listFile) {
            if (Files.isDirectory(file)) {
                Copy(file);
            } else {
                System.out.println(file);
                System.out.println(destino);
                this.Copy(file, algo);
            }
        }
    }
}