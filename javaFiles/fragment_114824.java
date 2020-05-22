File src = new File("c:\\temp\\srctest");
File dest = new File("c:\\temp\\desttest");
Path srcPath = src.toPath();
Path destPath = dest.toPath();

Files.walkFileTree(srcPath, new CopyDirVisitor(srcPath, destPath, StandardCopyOption.REPLACE_EXISTING));

public static class CopyDirVisitor extends SimpleFileVisitor<Path>
{
    private final Path fromPath;
    private final Path toPath;
    private final CopyOption copyOption;

    public CopyDirVisitor(Path fromPath, Path toPath, CopyOption copyOption)
    {
        this.fromPath = fromPath;
        this.toPath = toPath;
        this.copyOption = copyOption;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException
    {
        Path targetPath = toPath.resolve(fromPath.relativize(dir));
        if( !Files.exists(targetPath) )
        {
            Files.createDirectory(targetPath);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
    {
        Files.copy(file, toPath.resolve(fromPath.relativize(file)), copyOption);
        return FileVisitResult.CONTINUE;
    }
}