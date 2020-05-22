public ChatServer( int port ) throws UnknownHostException {
            super( new InetSocketAddress( port ) );
    }

    public ChatServer( InetSocketAddress address ) {
            super( address );
    }