boolean running = true;
BufferedInputStream reader = new BufferedInputStream(new FileInputStream( "out.txt" ) );

public void run() {
    while( running ) {
        if( reader.available() > 0 ) {
            System.out.print( (char)reader.read() );
        }
        else {
            try {
                sleep( 500 );
            }
            catch( InterruptedException ex ) {
                running = false;
            }
        }
    }
}