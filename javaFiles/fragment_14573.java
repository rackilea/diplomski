import java.awt.EventQueue;
import javax.swing.SwingWorker;

public class SwingWorker05 {
public static void main(String [] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
            W w = new W();
            w.execute();
            Thread.sleep(1000);
            try{w.cancel(false);}catch (RuntimeException rte) {
                rte.printStackTrace();
            }
            Thread.sleep(6000);
            } catch (InterruptedException ignored_in_testing) {}
        }

    });
}

public static class W extends SwingWorker <Void, Void> {

    @Override
    protected Void doInBackground() throws Exception {
        while (!isCancelled()) {
            Thread.sleep(5000);
        }
        System.out.println("I'm still alive");
        return null;
    }

    @Override
    protected void done() {throw new RuntimeException("I want to produce a stack trace!");}

}

}