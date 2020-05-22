import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ActionTest {

    public static void main(String[] args) {
        new ActionTest();
    }

    public ActionTest() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            add(createButton(new ActionOne(), KeyStroke.getKeyStroke(KeyEvent.VK_1, 0)));
            add(createButton(new ActionTwo(), KeyStroke.getKeyStroke(KeyEvent.VK_2, 0)));
        }

        public JButton createButton(Action action, KeyStroke keyStroke) {
            JButton btn = new JButton(action);
            btn.getInputMap(WHEN_IN_FOCUSED_WINDOW).put(keyStroke, "button_pressed");
            btn.getActionMap().put("button_pressed", action);
            return btn;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.dispose();
        }

    }

    public class ActionOne extends AbstractAction {

        public ActionOne() {
            putValue(NAME, "1");
            putValue(Action.ACTION_COMMAND_KEY, "Action.one");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }

    }

    public class ActionTwo extends AbstractAction {

        public ActionTwo() {
            putValue(NAME, "2");
            putValue(Action.ACTION_COMMAND_KEY, "Action.two");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
        }

    }

}