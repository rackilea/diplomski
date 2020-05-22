import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class InternalFrameDemo1 extends JPanel {

    JDesktopPane desktop;
    JButton button;

    public InternalFrameDemo1() {
        desktop = new JDesktopPane();
        button = new JButton("Get Next Frame");

        setLayout(new BorderLayout());
        add(desktop, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (desktop.getAllFrames().length == 0) {
                    desktop.add(new MyInternalFrame());

                } else {
                    desktop.remove(0);
                    desktop.add(new MyInternalFrame());
                    revalidate();
                    repaint();
                }
            }
        });
    }

    public static void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.add(new InternalFrameDemo1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);

    }

    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

import javax.swing.JInternalFrame;

public class MyInternalFrame extends JInternalFrame {
    static int openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;

    public MyInternalFrame() {
        super("Document #" + (++openFrameCount),
              true, //resizable
              true, //closable
              true, //maximizable
              true);//iconifiable

        setSize(300,300);
        setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
        setVisible(true);
    }
}