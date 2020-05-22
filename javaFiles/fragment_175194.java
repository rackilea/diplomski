import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFileVisitor extends SimpleFileVisitor<Path> {
    private final Path targetPath;
    private Path sourcePath = null;

    public CopyFileVisitor(Path targetPath) {
        this.targetPath = targetPath;
    }

    @Override
    public FileVisitResult preVisitDirectory(final Path dir,
            final BasicFileAttributes attrs) throws IOException {
        if (sourcePath == null) {
            sourcePath = dir;
        } else {
            Path destDir = targetPath.resolve(sourcePath.relativize(dir));
            System.out.println("Creating directory: " + destDir);
            Files.createDirectories(destDir);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(final Path file,
            final BasicFileAttributes attrs) throws IOException {
        Path destFilePath = targetPath.resolve(sourcePath.relativize(file));
        System.out.println("Copying " + file.toAbsolutePath() + " to " + destFilePath.toAbsolutePath());
        Files.copy(file, destFilePath);
        return FileVisitResult.CONTINUE;
    }
}