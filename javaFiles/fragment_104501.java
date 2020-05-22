import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ImageInSouthEast {

    private JComponent ui = null;

    ImageInSouthEast() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new GridBagLayout());
        ui.setBorder(new EmptyBorder(4,4,4,4));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 2;
        gbc.weighty = .5;
        gbc.weightx = .5;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // first add the labels
        for (int ii=1; ii<5; ii++) {
            gbc.gridy = ii;
            if (ii==4) {
                gbc.gridwidth = 1;
            }
            JLabel l = new JLabel("Label " + ii);
            l.setFont(l.getFont().deriveFont(50f));
            ui.add(l, gbc);
        }

        // now for the image!
        BufferedImage bi = new BufferedImage(100, 50, BufferedImage.TYPE_INT_RGB);
        JLabel l = new JLabel(new ImageIcon(bi));
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.gridx = 2;
        gbc.weighty = 0;
        ui.add(l, gbc);
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
                ImageInSouthEast o = new ImageInSouthEast();

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