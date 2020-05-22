import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
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

                JMenuBar mb = new JMenuBar();
                JMenu menu = new JMenu("Lots-o-stuff");
                mb.add(menu);

                menu.add(new MyMenuItem("Apples"));
                menu.add(new MyMenuItem("Pears"));
                menu.add(new MyMenuItem("Bananas"));

                JFrame frame = new JFrame("Testing");
                frame.setJMenuBar(mb);
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
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class MyMenuItem extends JCheckBoxMenuItem {

        public MyMenuItem() {
        }

        public MyMenuItem(Icon icon) {
            super(icon);
        }

        public MyMenuItem(String text) {
            super(text);
        }

        public MyMenuItem(Action a) {
            super(a);
        }

        public MyMenuItem(String text, Icon icon) {
            super(text, icon);
        }

        public MyMenuItem(String text, boolean b) {
            super(text, b);
        }

        public MyMenuItem(String text, Icon icon, boolean b) {
            super(text, icon, b);
        }

        @Override
        protected void processMouseEvent(MouseEvent evt) {
            if (evt.getID() == MouseEvent.MOUSE_RELEASED && contains(evt.getPoint())) {
                doClick();
                setArmed(true);
            } else {
                super.processMouseEvent(evt);
            }
        }
    }

}