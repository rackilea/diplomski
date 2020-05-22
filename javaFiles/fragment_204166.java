public class ClientWrapper implements Runnable {

  private final String ip;
  private final String port;
  private Client client;
  Lock lock = new ReentrantLock();

  /**
   * Creates a new instance of ClientWrapper.
   * 
   * @param ip
   * @param port
   */
  public ClientWrapper(String ip, String port) {

    this.ip = ip;
    this.port = port;
  }

  public Lock getLock() {

    return lock;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void run() {

    lock.lock();
    client = new Client(ip, port);
    lock.unlock();
  }

  //create a method to expose client or its methods. 


}