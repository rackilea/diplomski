public class Test implements Runnable {

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("alive");
        }
    }



    public static void main(String[] args) {
        new Thread(new Test()).start();
        throw new OutOfMemoryError();
    }
}