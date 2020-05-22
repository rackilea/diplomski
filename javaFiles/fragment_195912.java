public static void walkThroughDir( String path, String fname ) {
    File root = new File( path );
    File[] list = root.listFiles();

    if (list == null) return;

    for ( File f : list ) {
        if ( f.isDirectory() ) {
          walkThroughDir( f.getAbsolutePath(), fname );
        }
        else {
          if (f.getName().equals(fname)) {
            System.out.println( "File:" + f.getAbsoluteFile() );
            return;
          }
    }
  }