import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.io.PrintWriter;
    import java.net.ServerSocket;
    import java.net.Socket;

    public class NewServer {

      public static final void main(final String[] args) {
        int portNumber = 1342;

        try ( 
            ServerSocket serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
          String s = "SERVER: Started.";
          out.println(s);
          while ((s = in.readLine()) != null) {
              System.out.println("RECV: "+s);
              String[] ss = s.split("PUSH\\s");
              out.println(Integer.parseInt(ss[1]) + 2 + "");
              System.out.println("SEND: " + Integer.parseInt(ss[1]) + 2);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }

      }
    }


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

  public static final void main(final String[] args) {
    String hostName = "127.0.0.1";
    int portNumber = 1342;

    try (
        Socket client = new Socket(hostName, portNumber);
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(client.getInputStream()));
    ) {
      String fromServer = null;
      client.setKeepAlive(true);
      while ((fromServer = in.readLine()) != null) {
        System.out.println(fromServer);
        out.println("PUSH 567");
      }
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}