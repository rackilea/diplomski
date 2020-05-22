public class UserRequest implements Runnable {

  @Override
  public void run() {
    String request;
    Scanner input = new Scanner(System.in);

    while(true) {
      System.out.println("Please enter request:");
      request = input.nextLine();

      try {
        //do something

      } catch(IOException e) {
        e.printStackTrace();

      } finally {
        this.notifyAll(); // Notifies all sleeping threads to wake up
      }
    }
  }