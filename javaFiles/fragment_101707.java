import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

public class Mult2 extends JPanel {
    private JTextField field1 = new JTextField(10);
    private JTextField field2 = new JTextField(10);

    public Mult2() {
        setLayout(new GridBagLayout());

        add(new JLabel("Enter the First Number:"), createGbc(0, 0));
        add(field1, createGbc(1, 0));
        add(new JLabel("Enter the Second Number:"), createGbc(0, 1));
        add(field2, createGbc(1, 1));

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setBackground(Color.PINK);
    }

    private static GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        int right = x % 2 == 0 ? 15 : 5;
        gbc.insets = new Insets(5, 5, 5, right);
        return gbc;
    }

    private static void createAndShowGui() {
        Mult2 mainPanel = new Mult2();

        JFrame frame = new JFrame("Multiply");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}