import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class Memory extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                makeItSo();
            }
        });
    }

    public static void makeItSo() {
        final JDialog loading = new JDialog();
        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(new JLabel("Please wait..."), BorderLayout.CENTER);
        loading.setUndecorated(true);
        loading.getContentPane().add(p1);
        loading.pack();
        loading.setLocationRelativeTo(null);
        loading.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        loading.setModal(true);
        SwingWorker<String, Void> worker = new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws InterruptedException {
                Thread.sleep(5000);
                return "hello";
            }

            @Override
            protected void done() {
                loading.dispose();
            }
        };
        worker.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(evt.getPropertyName());
                Object value = evt.getNewValue();
                if (value instanceof SwingWorker.StateValue) {
                    SwingWorker.StateValue state = (SwingWorker.StateValue) value;
                    switch (state) {
                        case DONE: {
                            try {
                                String result = worker.get();
                                JOptionPane.showMessageDialog(null, result);
                            } catch (InterruptedException | ExecutionException ex) {
                                ex.printStackTrace();
                            }
                        }
                        break;
                    }
                }
            }
        });
        worker.execute();
        loading.setVisible(true);
    }

}