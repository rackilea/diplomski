private static boolean isLink( File f ) {
    Path p = Paths.get( f.toString() );
    return Files.isSymbolicLink( p );
}
private static long usedSpace( File path ) //throws FileExistsException
{
    long size = 0l;
    if ( path == null ) {
        System.out.println( "ERROR: No Files in " + path );
        System.out.println("exists   :" + path.exists() );
        System.out.println("isDir    :" + path.isDirectory() );
        System.out.println("isFile   :" + path.isFile() );
        System.exit(1);
    }
    if ( isLink( path ) ) {
        return 0;
    }
    int c = 0;
    try {
        c = path.listFiles().length;
    } catch (Exception e) {
        System.out.println( "path : " + path );
        System.out.println( "link : " + isLink( path ) );
        System.out.println( "file : " + path.isFile() );
        System.out.println( "dir  : " + path.isDirectory() );
        System.out.println( "list : " + path.listFiles() );
        System.out.println( "count: " + c );
        e.printStackTrace();
    }
    if ( c == 0 ) {
        return 0;
    }
    for ( File file : path.listFiles()) {
        if ( file.isDirectory() ) {
            size += usedSpace(file);
        } else {
            try {
                if ( isLink( file ) ) {
                    //+=0
                } else {//file.isFile() …
                //} else if(Files.isRegularFile(link)) {// had e.g. sockets and a pipe
                    //                System.out.println(file.getName() + " " + file.length());
                    size += file.length();
                }
            } catch(NullPointerException e) {
                System.out.println( file.toString()
                        + "\t" + e.getStackTrace());
            }
        }

    }
    return size;
}