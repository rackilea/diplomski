import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class ActionTest {

    public ActionTest() {
        ImageIcon openIcon = new ImageIcon(
                ActionTest.class.getResource("/resources/image/open.gif"));
        ImageIcon saveIcon = new ImageIcon(
                ActionTest.class.getResource("/resources/image/save.gif"));
        ImageIcon newIcon = new ImageIcon(
                ActionTest.class.getResource("/resources/image/new.gif"));

        Action openAction = new AbstractAction("Open", openIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open File");
            }
        };
        Action saveAction = new AbstractAction("Save", saveIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Save File");
            }
        };
        Action newAction = new AbstractAction("New", newIcon) {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("New File");
            }
        };

        JMenuItem openMenuItem = new JMenuItem(openAction);
        JMenuItem saveMenuItem = new JMenuItem(saveAction);
        JMenuItem newMenuItem = new JMenuItem(newAction);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(newMenuItem);
        menuBar.add(fileMenu);

        JToolBar toolBar = new JToolBar();
        toolBar.add(Box.createHorizontalGlue());
        toolBar.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
        toolBar.add(newAction);
        toolBar.add(openAction);
        toolBar.add(saveAction);

        JFrame frame = new JFrame("Toolbar and Menu Test");
        frame.setJMenuBar(menuBar);
        frame.add(toolBar, BorderLayout.PAGE_START);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ActionTest();
            }
        });
    }
}