private static void server() throws Exception {

        // initialize connection

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind( new InetSocketAddress( WELL_KNOWN_PORT ) );
        System.out.println( "waiting for client to connect" );

        SocketChannel socketChannel = serverSocketChannel.accept();