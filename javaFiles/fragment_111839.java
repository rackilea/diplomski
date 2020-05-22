import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

class MyMenu implements ActionListener {

    JTextField tf = new JTextField();
    JFrame jf = new JFrame("My Menu");
    JMenuBar menubar;
    JMenu menu, SubMenu;
    JMenuItem menuItem, exit;
    JScrollPane jp;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;

    MyMenu() {
        jf.add(tf, BorderLayout.NORTH);
        menubar = new JMenuBar();
        menu = new JMenu("First Menu");
        menu.setMnemonic(KeyEvent.VK_F);
        menubar.add(menu);

        jp = new JScrollPane(new JTextArea(10, 20));
        jf.add(jp);
        menuItem = new JMenuItem("Ank");
        //menuItem.setActionCommand("Ank");
        menuItem.addActionListener(this);
        KeyStroke i = KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK);
        menuItem.setAccelerator(i);
        menu.add(menuItem);

        //a grp of radioButton menu items
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("Radio Button menu item");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.addSeparator();

        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);
        cbMenuItem = new JCheckBoxMenuItem("ANother1");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);

        //a submenu
        menu.addSeparator();
        SubMenu = new JMenu("A SUbmenu");
        SubMenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem(" Item q");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        SubMenu.add(menuItem);

        menuItem = new JMenuItem("Another q");
        SubMenu.add(menuItem);
        menu.add(SubMenu);
        exit = new JMenuItem("EXIT");
        exit.addActionListener(this);
        menu.add(exit);

        //..Build a second menu.
        menu = new JMenu("another Menu");
        menu.setMnemonic(KeyEvent.VK_N);
        menubar.add(menu);
        jf.setJMenuBar(menubar);
        jf.pack();
        jf.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("EXIT")) {
            System.exit(0);
        }
        if (e.getActionCommand().equals("Ank1")) {
            tf.setText("helloo");
        }
    }

    public static void main(String... c) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                new MyMenu();
            }
        });
    }
}