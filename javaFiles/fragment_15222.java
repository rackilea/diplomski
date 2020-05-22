Server server = new Server(8080);
WebSocketHandler wsHandler = new WebSocketHandler()
    {
        @Override
        public void configure(WebSocketServletFactory factory)
        {
            factory.register(MyEchoSocket.class);
        }
    };
ContextHandler context = new ContextHandler();
context.setContextPath("/echo");
context.setHandler(wsHandler);
server.addHandler(context);
server.start();
server.join();