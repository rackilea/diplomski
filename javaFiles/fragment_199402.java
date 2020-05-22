public class Cls1 extends Thread {
    Cls1() {
        start();       
    }

    @Override
    public void run() {
        System.out.println("hello1");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("hello2");
    }
}