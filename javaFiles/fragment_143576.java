public class Provider implements Runnable  {
  ...
  public void run(){//manages the connection but ONE at a time.
    while(true){
       server.run();
    }
  }
  public static void main(String[] arg){
    Provider server = new Provider();
    new Thread(this).start();//start the connection processing with another thread.
  }
  ...
}