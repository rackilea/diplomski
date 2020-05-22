Socket s1 = new Socket();
    s1.bind(new InetSocketAddress("127.0.0.1", 7070));
    s1.connect(new InetSocketAddress("127.0.0.1", SERVER_PORT));

    Socket s2 = new Socket();
    s2.bind(new InetSocketAddress("127.0.0.1", 7070));
    s2.connect(new InetSocketAddress("127.0.0.1", SERVER_PORT));