public abstract class Connection {
  private int port;
  private int ipAddress;

  public Connection() {}

  public String description() {
     return "Generic";
  }

  public int accept(ConnectionVisitor visitor){
     return visitor.visit(this);
  }