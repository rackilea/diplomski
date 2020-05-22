import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class DataMigration extends JFrame {

    private JFrame frmDataMigration;

    private JFrame loader;

    private JButton btnProcess;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DataMigration window = new DataMigration();
                    window.frmDataMigration.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public DataMigration() {
        initialize();
    }

    private void initialize() {

        frmDataMigration = new JFrame();

        btnProcess = new JButton("Load");
        btnProcess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                initLoadingPanel();
                SwingWorker worker = new SwingWorker() {

                    @Override
                    protected Object doInBackground() throws Exception {
                        Thread.sleep(5000);
                        return "This is a test value used to highlight the example";
                    }

                    @Override
                    protected void done() {
                        try {
                            get();
                        } catch (ExecutionException ex) {
                        } catch (InterruptedException ex) {
                        }
                        loader.dispose();
                        btnProcess.setEnabled(true);
                    }

                };
                worker.execute();
                btnProcess.setEnabled(false);
            }
        });
        frmDataMigration.getContentPane().add(btnProcess);
        frmDataMigration.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frmDataMigration.pack();
        frmDataMigration.setLocationRelativeTo(null);
    }

    public void initLoadingPanel() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                loader = new JFrame("Loading....");
                ImageIcon img = new ImageIcon("loader.gif");
                loader.add(new JLabel(" Loading...", img, JLabel.CENTER));

                loader.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                loader.setAlwaysOnTop(true);
                loader.pack();
                loader.setSize(448, 497);
                loader.setVisible(true);
                loader.setLocationRelativeTo(null);
            }
        });

    }
}