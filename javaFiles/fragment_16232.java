import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JLabel label;

        public TestPane() {
            setLayout(new GridBagLayout());
            label = new JLabel("...");
            add(label);
            new ClockWorker(label).execute();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public static class ClockWorker extends SwingWorker<Void, String> {

        protected static final DateFormat DF = new SimpleDateFormat("hh:mm.ss SSS a");

        private JLabel label;

        public ClockWorker(JLabel label) {
            this.label = label;
        }

        @Override
        protected void process(List<String> chunks) {
            label.setText(chunks.get(chunks.size() - 1));
        }



        @Override
        protected Void doInBackground() throws Exception {
            while (true) {
                publish(DF.format(new Date()));
                Thread.sleep(1);
            }
        }

    }

}