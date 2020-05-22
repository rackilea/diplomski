public static void startClient() throws Exception {
    String stringURL = "rmi://127.0.0.1/" + MyService.class.getName();
    toRemoteInterface(MyService.class);// define the Remote interface in client classloader
    MyService service = fromRemote(Naming.lookup(stringURL), MyService.class);
    String said = service.sayHello("Dean");
    System.out.println("Client heard: " + said);
    service.throwIt();
  }

  public static void startServer() throws Exception {
    LocateRegistry.createRegistry(1099);
    Remote remote = toRemote(new MyServiceImpl(), MyService.class);
    Naming.rebind(MyService.class.getName(), remote);
    System.out.println(remote);
    System.out.println(remote.getClass());
    System.out.println("Server started!");
  }