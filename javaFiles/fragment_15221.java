Server server = new Server(8080);
WebSocketHandler wsHandler = new WebSocketHandler()
    {
        @Override
        public void configure(WebSocketServletFactory factory)
        {
            factory.register(MyEchoSocket.class);
        }
    };
server.addHandler(wsHandler);
server.start();
server.join();