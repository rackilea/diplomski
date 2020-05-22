public static void main ( String[] args ) throws InterruptedException {
    Runtime.getRuntime ().addShutdownHook ( new Thread () {
        @Override
        public void run () {
            System.out.println ( "Shutdown hook" );
            while ( true ) { }
        }
    } );

    while ( true ) {
        System.out.println ( "Looping" );
        Thread.sleep ( 10000 );
    }
}