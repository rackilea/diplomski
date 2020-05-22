public class FlashThread implements Runnable {
  private JLabel temp;
  Thread thread;
  Color randColor;

  public FlashThread(JLabel toFlash) {
    temp = toFlash;
    thread = new Thread(this);
    thread.start();
  }

  public void run() {
    final Random r = new Random();
    while (true) {
        SwingUtilities.invokeAndWait(new Runnable(){
           public void run() {
              // this will be executed in the EDT
              temp.setForeground(new Color(r.nextInt(246) + 10,
                r.nextInt(246) + 10, r.nextInt(246) + 10));
              // don't perform long running tasks in the EDT or sleep
              // this would lead to non-responding user interfaces
           }
        });
        // Let our create thread sleep
        try {
            Thread.sleep(r.nextInt(500));
        } catch (InterruptedException e) {
        }
    }
  }
}