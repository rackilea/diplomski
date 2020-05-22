class Node0
  private Server server;
  ...
  public void init(){
      server.setNode(this);
      server.waitConnections();
  ...
  public doPackage(Package p){
      // do something with p;
  ...

class Server
  public setNode(Node n) {
      this.node = n;
  }
  socket = ss.accept(); // ss :socketServer object
  handler = new Handler(socket, node);
  handler.start(); // start handler thread

class Handler
  ...
  public Handler(Socket socket, Node node){
    this.socket = socket;
    this.node = node;      
  }
  public void run() {
    while (true) {
      try {
        package = (Package) ois.readObject(); // ois :ObjectInputStream
        if (package != null) {
          // this.setPackage(package);
          this.node.doPackage(package);
        }
      } catch (Exception e) {
        break;
      }
  }