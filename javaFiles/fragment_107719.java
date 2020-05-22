private static double readDouble( BufferedReader kbd, String prompt ){
    String line = null;
    double res = 0;
    while( true ){
        System.out.print( prompt + " " );
        try {
            line = kbd.readLine();
        } catch( IOException ioe ){
            System.out.println( ioe.getMessage() );
            throw new IllegalStateException();
        }
        if( line == null ){
            System.out.println( "input terminated" );
            continue;
        }
        line = line.trim();
        if( line.length() == 0 ){
            System.out.println( "input line can't be blank" );
            continue;
        }
        try {
            res = Double.parseDouble( line );
        } catch( NumberFormatException nfe ){
            System.out.println( "error in number" );
            continue;
        }
        if( res < 0 ){
            System.out.println( "input must not be negative" );
            continue;
        }
        return res;
    }
}