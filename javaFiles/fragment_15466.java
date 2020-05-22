public class MyThread extends Thread{
  public void run(){
    while(!interrupted()){
      try{
        // Place your code here
      }catch(InterruptedException e){
        break;
      }
    }
  }
}