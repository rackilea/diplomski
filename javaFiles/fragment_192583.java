import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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

            MenuHandler menuHandler = new MenuHandler();

            changed_Name = new JMenuItem("Change Name");
            changed_Name.setMnemonic(KeyEvent.VK_C);
            changed_Name.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.ALT_MASK));
            changed_Name.getAccessibleContext().setAccessibleDescription("This Will Allow a Name Change");
            changed_Name.addActionListener(menuHandler);
            menu.add(changed_Name);

            exit = new JMenuItem("Exit");
            menu.add(exit);

            menu = new JMenu("Help");
            add(menu);

            menuItem = new JMenuItem("Help & Docs");
            //menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, KeyEvent.CHAR_UNDEFINED) );
            menuItem.getAccessibleContext().setAccessibleDescription("Get Help or View Software documents");
            menuItem.addActionListener(menuHandler);
            menu.add(menuItem);

            menuItem = new JMenuItem("About");
            menuItem.addActionListener(menuHandler);
            menu.add(menuItem);

            exit.addActionListener(menuHandler);

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