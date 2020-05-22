import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FourPanelLayout {

    private JComponent ui = null;

    FourPanelLayout() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new GridBagLayout());
        // It appears you don't want space around the panels.
        // If not, commment out or remove this line.
        ui.setBorder(new EmptyBorder(4,4,4,4));

        // create the panels, each with a transparent image to suggest a size
        JPanel bluePanel = new JPanel();
        bluePanel.setBackground(Color.CYAN);
        bluePanel.add(new JLabel(new ImageIcon(getTransparentImage(40, 20))));

        JPanel darkGrayPanel = new JPanel();
        darkGrayPanel.setBackground(Color.DARK_GRAY);
        darkGrayPanel.add(new JLabel(new ImageIcon(getTransparentImage(40, 20))));

        JPanel whitePanel = new JPanel();
        whitePanel.setBackground(Color.WHITE);
        whitePanel.add(new JLabel(new ImageIcon(getTransparentImage(40, 20))));

        JPanel grayPanel = new JPanel();
        grayPanel.setBackground(Color.GRAY);
        grayPanel.add(new JLabel(new ImageIcon(getTransparentImage(360, 80))));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.0f;
        gbc.weighty = 0.0f;
        gbc.gridx = 0;
        gbc.gridy = 0;

        ui.add(bluePanel, gbc);

        gbc.weightx = .5f;
        gbc.gridx = 1;
        ui.add(whitePanel, gbc);

        gbc.weighty = .5f;
        gbc.gridy = 1;
        ui.add(grayPanel, gbc);

        gbc.weightx = 0f;
        gbc.gridx = 0;
        //gbc.gridy
        ui.add(darkGrayPanel, gbc);
    }

    /* We use transparent images to give panels a natural size. */
    private Image getTransparentImage(int w, int h) {
        return new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
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
                FourPanelLayout o = new FourPanelLayout();

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