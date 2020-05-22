package so6540787;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  private final Socket socket;

  public Server(Socket socket) {
    this.socket = socket;
  }

  public void receiveFile(File file) throws IOException {
    byte[] b = new byte[1024];
    int len = 0;
    int bytcount = 1024;
    FileOutputStream inFile = new FileOutputStream(file);
    InputStream is = socket.getInputStream();
    BufferedInputStream in2 = new BufferedInputStream(is, 1024);
    while ((len = in2.read(b, 0, 1024)) != -1) {
      bytcount = bytcount + 1024;
      inFile.write(b, 0, len);
    }
    System.out.println("Bytes Writen : " + bytcount);

    // Sending the response back to the client.
    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
    oos.flush();
    oos.writeObject("ok");
    System.out.println("Message sent to the client is " + "ok");

    in2.close();
    inFile.close();
  }

  public static void main(String[] args) throws IOException {
    ServerSocket listen = new ServerSocket(10000, 1);
    Socket socket = listen.accept();
    Server server = new Server(socket);
    server.receiveFile(new File("c:/received.pdf"));
  }
}