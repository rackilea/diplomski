import javax.swing.*;

public class Unions {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() { public void run() {
            runEDT();
        }});
    }
    private static void runEDT() {
        final JDialog dialog = new JDialog((JFrame)null, true);
        new SwingWorker<Void,Void>() {
            @Override protected Void doInBackground() throws Exception {
                // But this is working.
                Thread.sleep(3000);
                return null;
            }
            @Override protected void done() {
                dialog.setVisible(false);
            }
        }.execute();
        dialog.setVisible(true);
    }
}