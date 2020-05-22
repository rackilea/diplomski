//MyServer.java
public class MyServer {

  private static int PORT = 12345;

  public static void main(String args[]) {

    ServerSocket s = new ServerSocket(PORT);
    while(true) new MyServerThread(s.accept());

  }