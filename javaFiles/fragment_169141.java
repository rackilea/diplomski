public class Mytest implements Runnable
{
  private static volatile boolean running = true;

  public void run()
  {
    while(running) {
      // do stuff
    }
  }

  public void stop() { running = false;}
}