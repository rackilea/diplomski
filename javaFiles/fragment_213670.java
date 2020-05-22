public static File getFileFromURLOrFileString( String fn ) {
    File f = new File( fn );
    URI u = null;
    int i = 0;
    if ( ! f.exists() ) {
        while ( fn.indexOf("file:") >= 0 ) {
            i = fn.indexOf("file:");
            System.out.println( " n: " + fn + " – " + i + " – " + ( (i >= 0) ? fn.substring(i) : "" ) );
            if ( i == 0 ) {
                fn = fn.replaceFirst("file:","");
            } else {
                fn = fn.substring(i);
            }
        }
        while ( fn.indexOf("//") >= 0 ) {
            fn = fn.replaceAll("//","/");
        }
        //System.out.println( " n: " + fn + " – " + fn.indexOf("//") );
        u = (new File( fn )).toURI();
        f = new File( u );
    }
    return f;
}