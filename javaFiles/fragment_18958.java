public class testServer {
public static void main(String[] args) {
    testServer server = new testServer();
    server.go();
}
public void go() {
    try {
        ServerSocket s = new ServerSocket(5000);
        while(true) {
            Socket sock = s.accept();

            PrintWriter writer = new PrintWriter(sock.getOutputStream());
            String toReturn = "No cake for you.";
            writer.println(toReturn);
            writer.flush();
        }
    } catch(IOException ex) {
        ex.printStackTrace();
    }
  }
}