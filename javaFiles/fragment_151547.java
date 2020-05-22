import java.awt.*;
import java.awt.event.*;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Test {

    private JDesktopPane jdpDesktop;
    private static int openFrameCount = 0;
    final JFrame frame = new JFrame("JInternalFrame Usage Demo");

    public Test() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // A specialized layered pane to be used with JInternalFrames
        jdpDesktop = new JDesktopPane() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(500, 500);
            }
        };


        for (int i = 0; i < 3; i++) {
            createFrame(); // Create first window
        }

        frame.setContentPane(jdpDesktop);

        frame.setJMenuBar(createMenuBar());

        // Make dragging faster by setting drag mode to Outline
        jdpDesktop.putClientProperty("JDesktopPane.dragMode", "outline");

        frame.pack();
        frame.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Frame");
        menu.setMnemonic(KeyEvent.VK_N);
        JMenuItem menuItem = new JMenuItem("New IFrame");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createFrame();
            }
        });
        menu.add(menuItem);
        menuBar.add(menu);


        final JMenu jmWindows = new JMenu("Opened Windows");
        jmWindows.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent me) {
                jmWindows.removeAll();//remove previous opened window jmenuitems
                for (JInternalFrame ji : jdpDesktop.getAllFrames()) {
                    JMenuItem menuItem = new JMenuItem(ji.getTitle());
                    jmWindows.add(menuItem);
                }

                jmWindows.revalidate();
                jmWindows.repaint();
                jmWindows.doClick();

            }

            @Override
            public void menuDeselected(MenuEvent me) {
            }

            @Override
            public void menuCanceled(MenuEvent me) {
            }
        });
        menuBar.add(jmWindows);


        return menuBar;
    }

    protected void createFrame() {
        Test.MyInternalFrame frame = new Test.MyInternalFrame();
        frame.setVisible(true);
        // Every JInternalFrame must be added to content pane using JDesktopPane
        jdpDesktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test();
            }
        });
    }

    class MyInternalFrame extends JInternalFrame {

        static final int xPosition = 30, yPosition = 30;

        public MyInternalFrame() {
            super("IFrame #" + (++openFrameCount), true, // resizable
                    true, // closable
                    true, // maximizable
                    true);// iconifiable
            setSize(300, 300);
            // Set the window's location.
            setLocation(xPosition * openFrameCount, yPosition
                    * openFrameCount);
        }
    }
}