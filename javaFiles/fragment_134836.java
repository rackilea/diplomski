/**
 * Created by crabime on 11/10/16.
 */
public class DaemonTest extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            System.out.println(getName() + "  " + i);
        }
    }

    public static void main(String[] args) {
        DaemonTest d = new DaemonTest();
        d.setDaemon(true);
        d.start();
        try {
            Thread.sleep(200);//after 200 million seconds, main thread ends and no matter DaemonTest thread run to the end or not, it will stop 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}