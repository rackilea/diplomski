import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class SwingMain {

    private int phase = 1;
    private Timer moveTimer;

    SwingMain() {
        creategui();
    }

    void creategui(){

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.add(new APanel());
        f.pack();
        f.setVisible(true);
    }

    class APanel extends JPanel{

        private final JTextField tf;
        private final JButton start;

        APanel() {
            start = new JButton("Start");
            start.addActionListener(e-> startTimer());
            add(start);
            tf = new JTextField("Click Start",6);
            add(tf);
        }

        void startTimer() {

            start.setEnabled(false);
            ActionListener action = e -> autoPlay();

            moveTimer = new Timer(2000, action);
            moveTimer.setInitialDelay(500);
            moveTimer.start();
        }

        private void autoPlay() {

            switch (phase){
                case 1:
                    phase++;
                    move1();
                    break;
                case 2:
                    phase++;
                    move2();
                    break;
                case 3:
                    phase++;
                    move3();
                    break;
                default:
                    phase = 1;
                    moveTimer.stop();
                    tf.setText("Click Start");
                    start.setEnabled(true);
                    break;
            }
        }

        private void move1() {
            tf.setText("Move 1");
        }

        private void move2() {
            tf.setText("Move 2");
        }

        private void move3() {
            tf.setText("Move 3");
        }
    }

    public static void main(String[] args) {
        new SwingMain();
    }
}