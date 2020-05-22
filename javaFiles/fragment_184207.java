import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class StackOverflowExample2 extends JPanel {
    // 10 seconds between tasks
    private static final int TIMER_DELAY = 10 * 1000;
    int keyCode = KeyEvent.VK_P;
    int modifiers = InputEvent.SHIFT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK
            | InputEvent.ALT_DOWN_MASK;
    private KeyStroke shftCtrlAltP = KeyStroke.getKeyStroke(keyCode, modifiers);
    private int condition = WHEN_IN_FOCUSED_WINDOW;
    private InputMap inputMap = getInputMap(condition);
    private ActionMap actionMap = getActionMap();
    private Timer myTimer = new Timer(TIMER_DELAY, new TimerListener());

    public StackOverflowExample2() {
        setPreferredSize(new Dimension(400, 300));

        // create key binding
        inputMap.put(shftCtrlAltP, shftCtrlAltP.toString());
        actionMap.put(shftCtrlAltP.toString(), new MyAction());
        // myWorker.execute();
        myTimer.setInitialDelay(0);
        myTimer.start();
    }

    private class MyAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Key pressed");
            myTimer.restart(); // simply re-start the timer
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // launch SwingWorker or other thread to check if files have changed
            // and if so do file I/O
            System.out.println("Timer running");
        }
    }

    private static void createAndShowGui() {
        StackOverflowExample2 mainPanel = new StackOverflowExample2();

        JFrame frame = new JFrame("StackOverflowExample2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}