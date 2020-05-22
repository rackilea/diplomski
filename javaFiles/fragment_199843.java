import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FrameTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                initGui();
            }
        });
    }

    public static void initGui() {
        final JFrame f = new JFrame("Frame Test");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel gui = new JPanel(new GridLayout(0,1,5,5));
        final Content c = new Content();
        JButton frame = new JButton("Frame");
        frame.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JFrame f2 = new JFrame("Content");
                f2.add(c.getContent());
                f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f2.pack();
                f2.setLocationByPlatform(true);
                f2.setVisible(true);
            }
        });
        gui.add(frame);

        JButton dialog = new JButton("Dialog");
        dialog.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JDialog d = new JDialog(f);
                d.add(new Content().getContent());
                d.pack();
                d.setLocationByPlatform(true);
                d.setVisible(true);
            }
        });
        gui.add(dialog);

        f.add(gui);
        f.pack();
        f.setVisible(true);
    }
}

class Content {

    public Component getContent() {
        JPanel p = new JPanel();
        p.add(new JLabel("Hello World!"));
        return p;
    }
}