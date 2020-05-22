public static boolean isParent( File parent, File file ) {

    File f;
    try {
        parent = parent.getCanonicalFile();

        f = file.getCanonicalFile();
    } catch( IOException e ) {
        return false;
    }

    while( f != null ) {
        // equals() only works for paths that are normalized, hence the need for
        // getCanonicalFile() above. "a" isn't equal to "./a", for example.
        if( parent.equals( f ) ) {
            return true;
        }

        f = f.getParentFile();
    }

    return false;
}