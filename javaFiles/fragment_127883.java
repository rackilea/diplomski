GreetingServiceImpl gsi = new GreetingServiceImpl();
Server server = ServerBuilder.forPort(8080)
    .addService(gsi).build();

System.out.println("Starting server...");
gsi.init();
server.start();