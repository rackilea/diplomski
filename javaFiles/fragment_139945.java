import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;


public class GUI extends JFrame {

    private JLabel lblProgress = new JLabel("0%");

    public GUI() {
       setTitle("Swing worker example");
       setSize(300, 200);    
       add(lblProgress);
       new Process().execute();
    }


    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        });
    }

    class Process extends SwingWorker<String, String> {

        @Override
        protected String doInBackground() throws InterruptedException {
            int count = 10000;
            for (int i = 0; i < count; i++) {
                int progress = (int) ((double) i/count*100.0);
                lblProgress.setText(progress + "%");
                repaint();
                Thread.sleep(10);
            }
            return null;
        }

        @Override
        protected void done() {
            lblProgress.setText("Finished!");
        }
     }

 }