public class Poller implements Runnable {
  Queue<String> colors = new ConcurrentLinkedQueue<String>();

  public void poll() {
    while(this.colors.isEmpty()){
      Thread.currentThread().wait();
    }

    String color = this.colors.poll();

    while(color != null) {
      if(color == "") {
        //do work

      } else {
        //do work
      }

      color = this.colors.poll();
    }
  }

  @Override
  public void run() {
    colors.offer("Violet");
    colors.offer("Green");
    colors.offer("Yellow");
    colors.offer("Orange");

    while(true) {

      this.poll();
    }
  }
}