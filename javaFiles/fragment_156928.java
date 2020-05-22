class FileSystemImpl implements FileSystem {

    boolean exists(Path path){
        return Files.exists(path);
    }

    createDirectories(Path path){
        return Files.createDirectories(path);
    }

}