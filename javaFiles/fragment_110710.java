import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Time {

    int sec = 0;
    int min = 0;

    public Time() {
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
                frame.pack();
                frame.setLocationRelativeTo(null);

                ActionListener taskPerformer = new ActionListener() {
                    int sec = 0;
                    int min = 0;

                    public void actionPerformed(ActionEvent evt) {
                        if (sec >= 60) {
                            sec = 0;
                            min++;
                        }
                        System.out.println("Time passed: " + min + ":" + sec);
                        if (min == 2) {
                            System.out.println("Terminate");
                            System.exit(0);
                        }
                        sec++;
                    }
                };
                Timer timer = new Timer(1000, taskPerformer);
                timer.start();
            }
        });
    }

    public static void main(String[] args) {
        Time timer = new Time();
    }
}