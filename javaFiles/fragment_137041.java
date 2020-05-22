import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 *
 * @author Ryan
 */
public class Test {

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        JProgressBar jpb = new JProgressBar();
        jpb.setIndeterminate(true);
        frame.add(jpb);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Task().execute();
    }

    public static void method() { // This is a method that does a time-consuming task.
        for(int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    static class Task extends SwingWorker<Void, Void> {

        @Override
        protected Void doInBackground() throws Exception {
            /* Executing method on background thread.
             * The loading bar should keep moving because, although method() is time consuming, we are on a background thread.
            */ 
            method();
            return null;
        }

        @Override
        protected void done() {
            /* Executing method on Event Dispatch Thread.
             * The loading bar should stop because method() is time consuming and everything on the Event Dispatch Thread
             * (like the motion of the progress bar) is waiting for it to finish.
            */

            // 
            method();
        }
    }
}