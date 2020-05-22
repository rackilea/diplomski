import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Main<T1, T2>  {


  Queue<T1> taskType1Queue = new ArrayBlockingQueue<T1>(10);
  Queue<T2> taskType2Queue= new ArrayBlockingQueue<T2>(10);
  ArrayBlockingQueue<Boolean> notificationQueue= new ArrayBlockingQueue<Boolean>(2);


  public void produceType1(T1 task) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        taskType1Queue.add(task);
        notificationQueue.offer(true);; //does not block if full
      }
    });
  }

  public void produceType2(T2 task) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        taskType2Queue.add(task);
        notificationQueue.offer(true); //does not block if full
      }
    });
  }


  public void consume() {

    try {
      notificationQueue.take();//wait till task1 o task2 has been published

      for(;!Thread.currentThread().isInterrupted();){
        T1 task1 = taskType1Queue.poll();//does not block if queue is empty
        if (task1 != null) {
          //do something
        }
        T2 task2 = taskType2Queue.poll();//does not block if queue is empty
        if (task2 != null) {
          //do something
        }
        if(task1 == null && task2 == null) {
          break;
        }
      }

    } catch (InterruptedException e) {
      System.out.println("Consumer thread done");
      return;
    }

  }

}