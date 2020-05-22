import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.net.*;

public class ImageSwitch {

    private JComponent ui = null;
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    ImageIcon imageIconA;
    ImageIcon imageIconB;

    ImageSwitch() {
        try {
            initUI();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }

    private void switchImages() {
        if (label1.getIcon().equals(imageIconA)) {
            label1.setIcon(imageIconB);
            label2.setIcon(imageIconA);
        } else {
            label1.setIcon(imageIconA);
            label2.setIcon(imageIconB);
        }
    }

    public void initUI() throws MalformedURLException {
        if (ui!=null) return;

        ui = new JPanel(new GridLayout(0,1,2,2));
        ui.setBorder(new EmptyBorder(4,4,4,4));

        imageIconA = new ImageIcon(new URL("https://i.stack.imgur.com/OVOg3.jpg"));
        imageIconB = new ImageIcon(new URL("https://i.stack.imgur.com/lxthA.jpg"));
        label1.setIcon(imageIconA);
        label2.setIcon(imageIconB);
        ui.add(label1);
        ui.add(label2);

        MouseListener mouseListener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                switchImages();
            }
        };
        label1.addMouseListener(mouseListener);
        label2.addMouseListener(mouseListener);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                ImageSwitch o = new ImageSwitch();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}