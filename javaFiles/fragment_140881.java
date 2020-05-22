public class MyFileVisitor implements FileVisitor<Path> {
    private int dirCount = 0;

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes bfa) throws IOException {
        System.out.println("Entering directory: " + path);
        dirCount++;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path path, IOException ex) throws IOException {
        System.out.println("Leaving directory: " + path);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes bfa) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path path, IOException ex) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public int getDirCount() {
        return dirCount;
    }

}