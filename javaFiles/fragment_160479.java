import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class MenuExample extends JPanel {

    private static final long serialVersionUID = 1L;
    private Icon errorIcon = UIManager.getIcon("OptionPane.errorIcon");
    private Icon infoIcon = UIManager.getIcon("OptionPane.informationIcon");
    private Icon warnIcon = UIManager.getIcon("OptionPane.warningIcon");
    private Icon questIcon = UIManager.getIcon("OptionPane.questionIcon");
    private JTextPane pane;
    private JMenuBar menuBar;

    public MenuExample() {
        menuBar = new JMenuBar();
        JMenu formatMenu = new JMenu("Justify");
        formatMenu.setMnemonic('J');
        MenuAction leftJustifyAction = new MenuAction("Left", errorIcon);
        MenuAction rightJustifyAction = new MenuAction("Right", infoIcon);
        MenuAction centerJustifyAction = new MenuAction("Center", warnIcon);
        MenuAction fullJustifyAction = new MenuAction("Full", questIcon);
        JMenuItem item;
        item = formatMenu.add(leftJustifyAction);
        item.setMnemonic('L');
        item = formatMenu.add(rightJustifyAction);
        item.setMnemonic('R');
        item = formatMenu.add(centerJustifyAction);
        item.setMnemonic('C');
        item = formatMenu.add(fullJustifyAction);
        item.setMnemonic('F');
        menuBar.add(formatMenu);
        menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));
        pane = new JTextPane();
        pane.setPreferredSize(new Dimension(250, 250));
        pane.setBorder(new BevelBorder(BevelBorder.LOWERED));
        JFrame frame = new JFrame("Menu Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menuBar);
        frame.add(pane, BorderLayout.CENTER);
        frame.pack();
        frame.setLocation(150, 150);
        frame.setVisible(true);
    }

    class MenuAction extends AbstractAction {

        public MenuAction(String text, Icon icon) {
            super(text, icon);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                pane.getStyledDocument().insertString(0,
                        "Action [" + e.getActionCommand()
                        + "] performed!\n", null);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String s[]) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MenuExample example = new MenuExample();
            }
        });
    }
}