final File folder = ...
final File[] files = folder.listFiles( new FilenameFilter() {
    @Override
    public boolean accept( final File dir,
                           final String name ) {
        return name.matches( "dailyReport_08.*\\.txt" );
    }
} );
for ( final File file : files ) {
    if ( !file.delete() ) {
        System.err.println( "Can't remove " + file.getAbsolutePath() );
    }
}