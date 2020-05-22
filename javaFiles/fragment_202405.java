package so6540787;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

  private final Socket socket;

  public Client(Socket socket) {
    this.socket = socket;
  }

  public void sendFile(File file) throws IOException, ClassNotFoundException {
    byte[] buf = new byte[1024];
    OutputStream os = socket.getOutputStream();
    BufferedOutputStream out = new BufferedOutputStream(os, 1024);
    FileInputStream in = new FileInputStream(file);
    int i = 0;
    int bytecount = 1024;
    while ((i = in.read(buf, 0, 1024)) != -1) {
      bytecount = bytecount + 1024;
      out.write(buf, 0, i);
      out.flush();
    }
    socket.shutdownOutput(); /* important */
    System.out.println("Bytes Sent :" + bytecount);

    ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
    ois.skip(Long.MAX_VALUE);
    String confirmation = (String) ois.readObject();
    System.out.println("from server : " + confirmation);

    out.close();
    in.close();
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Client client = new Client(new Socket("localhost", 10000));
    client.sendFile(new File("c:/tobesent.pdf"));
  }
}