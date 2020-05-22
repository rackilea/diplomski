import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ValignJPanel {

    public static void main(String args[]) {
        JFrame frame = new JFrame("Vertical Alignment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = wrapPanel(createPanel(), Component.TOP_ALIGNMENT);
        JPanel panel2 = wrapPanel(createPanel(), Component.CENTER_ALIGNMENT);
        JPanel panel3 = wrapPanel(createPanel(), Component.BOTTOM_ALIGNMENT);

        frame.setLayout(new GridLayout(1, 3));
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.setSize(400, 150);
        frame.setVisible(true);
    }

    private static JPanel wrapPanel(JPanel oldPanel, float alignment) {
        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.LINE_AXIS);
        panel.setLayout(layout);
        oldPanel.setAlignmentY(alignment);
        panel.add(oldPanel);
        return panel;
    }

    private static JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Hello world"));
        panel.add(new JTextField(10));
        panel.setBorder(new LineBorder(Color.red));
        panel.setMaximumSize( panel.getPreferredSize());
        return panel;
    }
}