Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
    @Override 
    public FileVisitResult preVisitDirectory( final Path dir, final BasicFileAttributes attrs ) throws IOException {
        if ( dir.equals( root ) ) return FileVisitResult.CONTINUE;
            process( dir );
            return FileVisitResult.SKIP_SUBTREE; //or CONTINUE for recursive processing
        }
    } 
);