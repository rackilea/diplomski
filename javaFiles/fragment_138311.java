public class SimplestServer
{
  public static void main(String[] args) throws Exception
  {
    Server server = new Server(8080);
    server.start();
    server.join();
  }
}