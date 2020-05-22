public class Main
{
    public static void main( String[] args ) throws URISyntaxException, IOException
    {

        File currentDir = new File( "." ); // Read current file location
        File targetDir = null;
        if (currentDir.isDirectory()) {
            File parentDir = currentDir.getCanonicalFile().getParentFile(); // Resolve parent location out fo the real path
            targetDir = new File( parentDir, "word_lists_1" ); // Construct the target directory file with the right parent directory
        }
        if ( targetDir != null && targetDir.exists() )
        {
            listDirectoryAndFiles( targetDir.toPath() );
        }
    }

    private static void listDirectoryAndFiles( Path path ) throws IOException
    {
        DirectoryStream<Path> dirStream = Files.newDirectoryStream( path );
        for ( Path p : dirStream )
        {
            System.out.println( p.getFileName() );
            if ( p.toFile().isDirectory() )
            {
                listDirectoryAndFiles( p );
            }
        }
    }

}