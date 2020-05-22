public class Thr implements Runnable {
  String string = "Yes ";
  public void run(){
    this.string = "No ";
  }
  public static void main (String args[]){
  Thr t = new Thr();
  Thread tr = new Thread(t);
  tr.start();
  for(int i = 0; i < 10; i++)
      System.out.println(t.string + tr.isAlive());
  } 
}