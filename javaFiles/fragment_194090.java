import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class JMenuItemLastOnMenuBar {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                createGUI();
            }
        });
    }

    private static void createGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setBounds(0, 0, 300, 300);

        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Menu 1");
        JMenuItem item1 = new JMenuItem("Item 1");
        menu.add(item1);
        bar.add(menu);

        JMenuItem item2 = new JMenuItem("Item 2") {
            @Override
            public Dimension getMaximumSize() {
                Dimension d1 = super.getPreferredSize();
                Dimension d2 = super.getMaximumSize();
                d2.width = d1.width;
                return d2;
            }
        };
        bar.add(item2);

        frame.setJMenuBar(bar);

        frame.pack();
        frame.setVisible(true);
    }

}