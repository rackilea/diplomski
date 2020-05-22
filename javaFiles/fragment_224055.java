import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MinimumSizeFrame {

    private JComponent ui = null;

    MinimumSizeFrame() {
        ui = new JPanel(new BorderLayout(4,4));

        JLabel label = new JLabel("Text in big label");
        label.setBorder(new EmptyBorder(40, 100, 40, 100));
        ui.add(label);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            MinimumSizeFrame o = new MinimumSizeFrame();

            JFrame f = new JFrame(o.getClass().getSimpleName());
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationByPlatform(true);

            f.setContentPane(o.getUI());
            // have the JVM calculate the ideal size of this GUI
            f.pack(); 
            // now use THAT as minimum size!
            f.setMinimumSize(f.getSize()); 

            f.setVisible(true);
        };
        SwingUtilities.invokeLater(r);
    }
}