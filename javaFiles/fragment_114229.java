import java.util.*;

    public class JobProcessor extends Thread
    {
       private Queue queue = new LinkedList();

       public void addJob(Object job)
       {
           synchronized(queue)
           {
              queue.add(job);
              queue.notify(); // lests the thread know that an item is ready
           }
       }


       @Overide
       public void run()
       {
          while (true)
          {
              Object job = null;

              synchronized(queue) // ensures thread safety
              {
                 // waits until something is added to the queue.
                 try
                   while (queue.isEmpty()) queue.wait();
                 catch (InterruptedException e)
                   ; // the wait method can throw an exception you have to catch.
                 // but can ignore if you like.

                 job = queue.poll();
              }
              // at this point you have the job object and can process it!
              // with minimal time waiting on other threads.
              // be sure to check that job isn't null anyway!
              // in case you got an InterruptedException.

              ... processing code ...

              // job done loop back and wait for another job in the queue.
          }
       }
    }