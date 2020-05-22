import java.io.*;
public class ConnectionManager {
    public static void main(String argv[]) throws Exception {
      PipedOutputStream pout = new PipedOutputStream();
      PipedInputStream pin = new PipedInputStream(pout);
      Sender s = new Sender(pout);
      Receiver r = new Receiver(pin);
      System.out.println("Starting threads");
      s.start();
      r.start();
    }
}

class Sender extends Thread {
  private final OutputStream os;
  Sender(OutputStream os) { this.os = os; }
  public void run() {
    try(ObjectOutputStream oos = new ObjectOutputStream(os)) {
      oos.writeInt(99);
      System.out.println("Message sent, terminating");
    } catch (Exception e) {
      System.out.println("Sender: " + e);
      e.printStackTrace();
    }
  }
}

class Receiver extends Thread {
  private final InputStream is;
  Receiver(InputStream is) {this.is = is; }
  public void run() {
    try(ObjectInputStream ois = new ObjectInputStream(is)) {
     System.out.println("waiting for a message");
     int x = ois.readInt();
     System.out.println("message received: " + x);
    } catch (Exception e) {
      System.out.println("Receiver: " + e);
      e.printStackTrace();
    }
  }
}