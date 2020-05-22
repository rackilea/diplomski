public class Task1 implements Runnable{
  final CountDownLatchlatch; 
  public Task1 (CountDownLatchlatch latch){ this.latch = latch; }
  public void run(){
    //do work
    latch.countDown();
  }
}
public class Task2 implements Runnable{
  final CountDownLatchlatch; 
  public Task2 (CountDownLatchlatch latch){ this.latch = latch; }
  public void run(){
    latch.await();
    //do work
  }
}