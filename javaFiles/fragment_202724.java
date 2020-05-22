import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TopAlignedComponents {

    private JComponent ui = null;

    TopAlignedComponents() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;

        ui = new JPanel(new BorderLayout(4,4));
        ui.setBorder(new EmptyBorder(4,4,4,4));

        JTabbedPane tb = new JTabbedPane();
        ui.add(tb);
        Image spacer = new BufferedImage(300, 100, BufferedImage.TYPE_INT_RGB);
        tb.addTab("Spacer", new JLabel(new ImageIcon(spacer)));

        String[] labels = {"Shapes", "Joints", "AABBs"};
        JPanel checkPanel = new JPanel(new GridLayout(0, 1, 4, 4));
        checkPanel.setBackground(Color.ORANGE);
        for (String label : labels) {
            checkPanel.add(new JCheckBox(label));
        }

        JPanel checkConstrain = new JPanel(new BorderLayout());
        checkConstrain.setBackground(Color.YELLOW);
        checkConstrain.add(checkPanel, BorderLayout.PAGE_START);

        tb.addTab("Check", checkConstrain);
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
                TopAlignedComponents o = new TopAlignedComponents();

                JFrame f = new JFrame("Top Aligned Components");
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