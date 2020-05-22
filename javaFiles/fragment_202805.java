public class WorkerRunnable implements Runnable{
  public WorkerRunnable(Socket socket,Baza0 ba){
     this.socket = socket;
     this.baza =ba;
  }
  public void run(){
     ...
     this.ba.method1(...);
  }
}