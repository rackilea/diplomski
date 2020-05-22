import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ProgressBar extends JFrame {

    JProgressBar current = new JProgressBar(0, 100);
    int num = 0;

    public ProgressBar() {
        //exit button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //create the panel to add the details
        JPanel pane = new JPanel();
        current.setValue(0);
        current.setStringPainted(true);
        pane.add(current);
        setContentPane(pane);
    }

    //to iterate so that it looks like progress bar  
    public void iterate() {
        SwingWorker worker = new SwingWorker<Object, Object>() {
            @Override
            protected Object doInBackground() throws Exception {
                while (num < 2000) {
//                    current.setValue(num);
                    try {
                        Thread.sleep(125);
                    } catch (InterruptedException e) {
                    }
                    num += 95;
                    int p = Math.round(((float)Math.min(num, 2000) / 2000f) * 100f);
                    setProgress(p);
                }
                return null;
            }
        };
        worker.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String name = evt.getPropertyName();
                if ("progress".equals(name)) {
                    SwingWorker worker = (SwingWorker) evt.getSource();
                    current.setValue(worker.getProgress());
                }
            }
        });
        worker.execute();
    }

    //for testing the app
    public static void main(String[] arguments) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                ProgressBar frame = new ProgressBar();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.iterate();
            }
        });
    }
}