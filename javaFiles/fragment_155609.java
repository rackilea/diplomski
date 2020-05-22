File root = new File( path );
    File[] list = root.listFiles(); // you can also use listFileAndDirs()

    if (list == null) return;

    for ( File f : list ) {
        if ( f.isDirectory() ) {
        //check for the name of 'calculation' and traverse it recursive