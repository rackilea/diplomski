public class TestConnection {
  public static void main(String[] args) {
    ConnectionFactory factory = new ConnectionFactory("SQLServer");
    Connection conn = factory.createConnection();

    conn = factory.createConnection();
    System.out.println(conn.description());
    ConnectionVisitor visitor = new DemoVisitor();
    System.out.println(conn.accept(visitor));
  }