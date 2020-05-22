public static void main(String test[])
{
    timer atimer = new timer();
    bomb abomb = new bomb();

    try {
       atimer.close();
       abomb.close();
    } catch ( java.io.IOException e ) {
        System.err.println( "An error occurred." );
    }
}