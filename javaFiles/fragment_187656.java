private static void delHelp(Path p) throws IOException {
    if (!p.toFile().exists()) {
        return;
    } else if(p.toFile().isFile()){
        Files.delete(p);
    } else if(p.toFile().isDirectory()){

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(p)) {
            for (Path subPath : ds){
                delHelp(subPath);
            }
        }

        Files.delete(p);
    }
}