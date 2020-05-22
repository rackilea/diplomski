import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AutoProgress {

    public static void main(String[] args) {
        new AutoProgress();
    }

    private JProgressBar pb;
    private int progress;

    public AutoProgress() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                pb = new JProgressBar();

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(pb);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                Timer timer = new Timer(50, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        progress += 1;
                        if (progress >= 100) {
                            progress = 100;
                            ((Timer)e.getSource()).stop();
                        }
                        pb.setValue(progress);
                    }
                });
                timer.start();
            }
        });
    }

}