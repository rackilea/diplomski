import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            JLabel label = new JLabel("...");
            MyAwesomeAction action = new MyAwesomeAction(new CounterListener() {
                @Override
                public void counterChanged(int count) {
                    label.setText("Button has been pressed " + count + " times");
                }
            });

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            JButton button = new JButton(action);
            add(button, gbc);
            add(label, gbc);

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "MakeItSo");
            am.put("MakeItSo", action);
        }

    }

    public interface CounterListener {

        public void counterChanged(int count);
    }

    public class MyAwesomeAction extends AbstractAction {

        private int count;
        private CounterListener listener;

        public MyAwesomeAction(CounterListener listener) {
            putValue(NAME, "Make it so");
            this.listener = listener;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            count++;
            listener.counterChanged(count);
        }

    }

}