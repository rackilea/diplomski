import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

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

                JMenuBar menuBar = new JMenuBar();
                JMenu menu = new JMenu("Stuff") {
                    private Border border = new LineBorder(Color.RED);
                    @Override
                    public JPopupMenu getPopupMenu() {
                        JPopupMenu menu = super.getPopupMenu();
                        menu.setBorder(border);
                        return menu;
                    }

                };
                JMenuItem mi = new JMenuItem("Help", 'H');
                mi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.META_MASK));
                menu.add(new JMenuItem("A"));
                menu.add(new JMenuItem("BB"));
                menu.add(new JMenuItem("CCC"));
                menu.add(mi);
                menuBar.add(menu);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.setJMenuBar(menuBar);
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

}