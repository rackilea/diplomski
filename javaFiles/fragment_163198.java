import java.io.IOException;

public class TestIt {

  public static void main(String[] argv) throws IOException {
    MyServer server = new MyServer();
    MyClient client = new MyClient();
    (new Thread(server)).start();
    (new Thread(client)).start();
  }
}