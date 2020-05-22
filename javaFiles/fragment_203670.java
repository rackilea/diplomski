final class DirectoryWalk {

    private DirectoryWalk() {
    }

    static void walk(final File root, final IDirectoryWalkListener listener)
            throws IOException {
        walk(0, root, listener);
    }

    private static void walk(final int level, final File root, final IDirectoryWalkListener listener)
            throws IOException {
        if ( !root.isDirectory() ) {
            throw new IOException(root + " must be a directory");
        }
        @Nullable
        final File[] files = root.listFiles();
        if ( files == null ) {
            throw new IOException("Cannot list files in " + root);
        }
        listener.onEnterDirectory(level, root);
        for ( final File file : files ) {
            if ( file.isDirectory() ) {
                walk(level + 1, file, listener);
            } else {
                listener.onFile(file);
            }
        }
        listener.onLeaveDirectory(level, root);
    }

}