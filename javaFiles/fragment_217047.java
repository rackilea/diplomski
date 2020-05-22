import java.awt.EventQueue;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Dmi {

    JFrame frame;
    JLabel lbl;

    Dmi() {
        frame = new JFrame("abc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbl = new JLabel("count");
        frame.add(lbl);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Worker worker = new Worker();
        worker.execute();
    }

    public class Worker extends SwingWorker<String, String> {

        @Override
        protected String doInBackground() throws Exception {
            while (!isCancelled()) {
                Thread.sleep(1000);
                publish("abc");
                Thread.sleep(300);
                publish("def");
            }
            return null;
        }

        @Override
        protected void process(List<String> chunks) {
            lbl.setText(chunks.get(chunks.size() - 1));
        }

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                Dmi dmi = new Dmi();
            }
        });
    }
}