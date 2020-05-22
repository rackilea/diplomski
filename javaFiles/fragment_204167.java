import java.util.concurrent.TimeUnit;

/**
 * @author rbhatt
 */
public class ClientCaller {

  public static void main(String args[]) throws InterruptedException {

    ClientWrapper clientWrapper = new ClientWrapper("127.0.0.1", "8080");

    Thread t = new Thread(clientWrapper);
    t.start();

    boolean ret = clientWrapper.getLock().tryLock(250, TimeUnit.MILLISECONDS);

    if (ret == false) {
      System.out.println("can not acquire lock in 250 milliseconds, kill the thread.");
      t.interrupt();
    } else {
      System.out.println("acquired lock in 250 milliseconds,release lock obtain client!");
      clientWrapper.getLock().unlock();
    }

  }

}