private static void client() throws Exception {

        // initialize connection

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking( true );
        socketChannel.connect( new InetSocketAddress( IP_ADDRESS, WELL_KNOWN_PORT ) );
        while ( !socketChannel.finishConnect() )
            Thread.sleep( 100 );