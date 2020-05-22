import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InnerPanel extends JPanel {

    public InnerPanel() {
        setOpaque(false);
        // To prove the point
        setBackground(Color.RED);
        JLabel label = new JLabel("testing");
        add(label);
    }
}