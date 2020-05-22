public static void main(String [] args){
    Unzipper unzipper = new Unzipper();
    unzipper.unzipZipsInDirTo(Paths.get("D:/"), Paths.get("D:/unzipped"));
}

public void unzipZipsInDirTo(Path searchDir, Path unzipTo ){

    final PathMatcher matcher = searchDir.getFileSystem().getPathMatcher("glob:**/*.zip");
    try (final Stream<Path> stream = Files.list(searchDir)) {
        stream.filter(matcher::matches)
                .forEach(zipFile -> unzip(zipFile,unzipTo));
    }catch (IOException e){
        //handle your exception
    }
}

public void unzip(Path zipFile, Path outputPath){
    try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(zipFile))) {

        ZipEntry entry = zis.getNextEntry();

        while (entry != null) {

            Path newFilePath = outputPath.resolve(entry.getName());
            if (entry.isDirectory()) {
                Files.createDirectories(newFilePath);
            } else {
                if(!Files.exists(newFilePath.getParent())) {
                    Files.createDirectories(newFilePath.getParent());
                }
                try (OutputStream bos = Files.newOutputStream(outputPath.resolve(newFilePath))) {
                    byte[] buffer = new byte[Math.toIntExact(entry.getSize())];

                    int location;

                    while ((location = zis.read(buffer)) != -1) {
                        bos.write(buffer, 0, location);
                    }
                }
            }
            entry = zis.getNextEntry();
        }
    }catch(IOException e){
        throw new RuntimeException(e);
        //handle your exception
    }
}