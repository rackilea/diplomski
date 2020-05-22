import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
                frame.setJMenuBar(new MenuBar());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ChangeNameAction extends AbstractAction {

        public ChangeNameAction() {
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.ALT_MASK));
            putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            putValue(NAME, "Change Name");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Change name");
        }
    }

    public class ExitAction extends AbstractAction {

        public ExitAction() {
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_4, KeyEvent.ALT_MASK));
            putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            putValue(NAME, "Exit");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public class HelpAction extends AbstractAction {

        public HelpAction() {
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
            putValue(MNEMONIC_KEY, KeyEvent.VK_H);
            putValue(NAME, "Help & Docs");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Help and docs");
        }
    }

    public class AboutAction extends AbstractAction {

        public AboutAction() {
            putValue(NAME, "About");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("About");
        }
    }

    public class MenuBar extends JMenuBar {

        // variable declaration
        private JMenu menu;
        private JMenuItem menuItem;
        private JMenuItem changed_Name;
        private JMenuItem exit;

        public MenuBar() {

            init();

        }

        private void init() {

            menu = new JMenu("File");
            add(menu);

            menu.add(new ChangeNameAction());
            menu.add(new ExitAction());

            menu = new JMenu("Help");
            add(menu);

            menu.add(new HelpAction());
            menu.add(new AboutAction());

        }

        private class MenuHandler implements ActionListener {

    //          AgentName userName = new AgentName();
            @Override
            public void actionPerformed(ActionEvent e) throws UnsupportedOperationException {

                Object menuItem_Command = e.getActionCommand();

                System.out.println(menuItem_Command);

                if (menuItem_Command.equals("Change Name")) {
                    System.out.println("Yippe");
                    //                  userName.setUserName(userName.getUserName());
                } else if (menuItem_Command.equals("Exit")) {
                    System.exit(0);
                }

            }

        }
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