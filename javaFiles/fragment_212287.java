import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

 */
public class ProgressBar extends JFrame {

    JProgressBar current = new JProgressBar(0, 100);
    JProgressBar overall = new JProgressBar(0, 100);
    int num = 0;

    public ProgressBar() {
        //exit button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //create the panel to add the details
        JPanel pane = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        current.setValue(0);
        current.setStringPainted(true);
        overall.setStringPainted(true);
        pane.add(overall, gbc);
        pane.add(current, gbc);
        setContentPane(pane);
    }

    //to iterate so that it looks like progress bar  
    public void iterate() {
        SwingWorker worker = new SwingWorker<Object, float[]>() {

            @Override
            protected void process(List<float[]> chunks) {
                float[] progress = chunks.get(chunks.size() - 1); // only want the last one
                overall.setValue(Math.round(progress[0] * 100f));
                current.setValue(Math.round(progress[1] * 100f));
            }

            @Override
            protected Object doInBackground() throws Exception {
                int size = 2000;
                int overallSize = size * 10;
                int overallProgress = 0;
                for (int index = 0; index < 10; index++) {
                    for (int count = 0; count < size; count++) {
                        publish(new float[]{
                            getProgress(overallProgress, overallSize),
                            getProgress(count, size),
                        });
                        overallProgress++;
                        Thread.sleep(2);
                    }
                }
                return null;
            }

            public float getProgress(int value, int max) {

                return (float)value / (float)max;

            }
        };
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