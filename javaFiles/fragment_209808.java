Path p = Paths.get( "/Volumes/Macintosh HD/Users/johndoe/text.txt" );
BasicFileAttributes view = null;
try {
    view = Files.getFileAttributeView( p, BasicFileAttributeView.class ).readAttributes();
} catch ( IOException ex ) {
    Logger.getLogger( App.class.getName() ).log( Level.SEVERE, null, ex );
}

// As of Java 7, the NIO package added yet another date-time class to the Java platform.
java.nio.file.attribute.FileTime fileTimeCreation = view.creationTime();
java.nio.file.attribute.FileTime fileTimeLastModified = view.lastModifiedTime();