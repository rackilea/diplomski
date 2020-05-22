import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

/** @see http://stackoverflow.com/questions/4373493 */
public class TimerFrame extends JFrame {

    private void display() {
        this.setTitle("TimerFrame");
        this.setLayout(new GridLayout(0, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new TimerButton("Back in a second", 1000));
        this.add(new TimerButton("Back in a minute", 60 * 1000));
        this.add(new TimerButton("Back in an hour", 60 * 60 * 1000));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /** A button that hides it's enclosing Window for delay ms. */
    private class TimerButton extends JButton {

        private final Timer timer;

        public TimerButton(String text, int delay) {
            super(text);
            this.addActionListener(new StartListener());
            timer = new Timer(delay, new StopListener());
        }

        private class StartListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                TimerFrame.this.setVisible(false);
                timer.start();
            }
        }

        private class StopListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                TimerFrame.this.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TimerFrame().display();
            }
        });
    }
}