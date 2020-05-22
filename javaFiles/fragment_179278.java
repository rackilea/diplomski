public static void main( String[  ] args ) {

try{
    final int begin = Integer.valueOf( args[ 1 ] );
    final int end = Integer.valueOf( args[ 2 ] );

    if( begin >= end ) {
        System.out.println( "Wrong arguments. (" + begin + " >= " + end + ")" );
        System.exit(1);
    }

} catch( NumberFormatException conversion_error ) {
    System.out.println( "Not A Number." );
    return;
}

System.out.print( "OK." );
System.exit(0);
}