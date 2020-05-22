package so;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class JTabbedEx extends JTabbedPane {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ImageIcon icon = new ImageIcon();
                JTabbedPane tabs = new JTabbedPane();
                tabs.addTab("Tab1", icon,null);
                new AnotherClass().addTab(tabs, icon);
                JFrame frame  = new JFrame();
                frame.add(tabs);
                frame.pack();
                frame.setVisible(true);
            }
        });         
    }
}

class AnotherClass {
    public void addTab(JTabbedPane tabs, ImageIcon icon) {
        tabs.addTab("Another tab", icon, null);
    }
}