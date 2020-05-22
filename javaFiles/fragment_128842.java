public class ZipWithExcludedDirs {
    final private Path         srcPath;
    final private Path         zipPath;
    final private List<String> excludeList = new ArrayList<>();


    public ZipWithExcludedDirs( Path srcPath, Path zipPath ) {
        this.srcPath = srcPath;
        this.zipPath = zipPath;
    }


    public void addDirExclude( String exDir ) {
        excludeList.add( exDir );
    }


    public void pack() throws IOException {
        try ( FileOutputStream fos = new FileOutputStream( zipPath.toFile() );
                ZipOutputStream zos = new ZipOutputStream( fos ) ) {
            Files.walkFileTree( srcPath, new SimpleFileVisitor<Path>() {
                public FileVisitResult visitFile( Path file, BasicFileAttributes attrs )
                        throws IOException {
                    zos.putNextEntry( new ZipEntry( file.toString() ) );
                    Files.copy( file, zos );
                    zos.closeEntry();
                    return FileVisitResult.CONTINUE;
                }


                public FileVisitResult preVisitDirectory( Path dir, BasicFileAttributes attrs )
                        throws IOException {
                    String dirName = dir.getFileName().toString();
                    for ( String excl : excludeList )
                        if ( dirName.equals( excl ) )
                            return FileVisitResult.SKIP_SUBTREE;

                    zos.putNextEntry( new ZipEntry( dir.toString() + "/" ) );
                    zos.closeEntry();
                    return FileVisitResult.CONTINUE;
                }
            } );
        }
    }
}