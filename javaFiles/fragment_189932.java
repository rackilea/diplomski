//MyServerThread.java
public class MyServerThread implements Runnable {

  private InputStream in = null;
  private OutputStream out = null;

  public MyServerThread(Socket s) {

    in = s.getInputStream();
    out = s.getOutputStream();

    (new Thread(this)).start();
  }

  public void run() {
    //do stuff with **in** and **out** to interact with client
  }
}