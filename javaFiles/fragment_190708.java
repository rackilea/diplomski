public class Bug {
    public static void main( String args[] ) {
        while ( true ) {
            /* If ANY of these two lines is not commented, the JVM
             runs out of memory */
            final Deflater deflater = new Deflater( 9, true );
            final Inflater inflater = new Inflater( true );
        }
    }
}