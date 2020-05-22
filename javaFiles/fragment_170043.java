import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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

    public interface Movable {
        public void changeLocation(int xDelta, int yDelta);
    }

    public class TestPane extends JPanel implements Movable {

        private JLabel player;

        public TestPane() {
            setLayout(null);
            player = new JLabel("X");
            player.setSize(player.getPreferredSize());
            add(player);

            setupKeyBindings();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void setupKeyBindings() {
            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "up");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "down");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "left");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "right");

            int xDelta = player.getWidth();
            int yDelta = player.getHeight();

            am.put("up", new MoveAction(this, 0, -yDelta));
            am.put("down", new MoveAction(this, 0, yDelta));
            am.put("left", new MoveAction(this, -xDelta, 0));
            am.put("right", new MoveAction(this, xDelta, 0));
        }

        @Override
        public void changeLocation(int xDelta, int yDelta) {
            int xPos = player.getX() + xDelta;
            int yPos = player.getY() + yDelta;
            if (xPos + player.getWidth() > getWidth()) {
                xPos = getWidth() - player.getWidth();
            } else if (xPos < 0) {
                xPos = 0;
            }
            if (yPos + player.getHeight() > getHeight()) {
                yPos = getHeight() - player.getHeight();
            } else if (xPos < 0) {
                yPos = 0;
            }
            player.setLocation(xPos, yPos);
        }

    }

    public class MoveAction extends AbstractAction{
        private Movable movable;
        private int xDelta;
        private int yDelta;

        public MoveAction(Movable movable, int xDelta, int yDelta) {
            this.movable = movable;
            this.xDelta = xDelta;
            this.yDelta = yDelta;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            movable.changeLocation(xDelta, yDelta);
        }

    }

}