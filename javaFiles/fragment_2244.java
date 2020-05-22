public class mainClass {

public static void main(String args[]) throws InterruptedException {

    final Processor processor = new Processor();

    Thread trainer = new Thread(new Runnable() {
        public void run() {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    Thread sportsman = new Thread(new Runnable() {
        public void run() {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

    trainer.start();
    sportsman.start();

    trainer.join();
    sportsman.join();

    System.out.println("100 Tasks are Finished."); 
}

}