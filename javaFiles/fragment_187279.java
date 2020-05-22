public class RegistryViewer {
  public static void main(String... args){
    String host = args[0];
    int port = Integer.parseInt(args[1]);
    Registry registry = LocateRegistry.getRegistry(host, port);
    for (String name : registry.list()) {
        System.out.println(name);
    }
  }    
}