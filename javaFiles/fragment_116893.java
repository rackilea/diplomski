public class MyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        if (file.toString().endsWith(".tar")) {
            return FileVisitResult.CONTINUE;
        }
        return super.visitFileFailed(file, exc);
    }
}