import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Testy extends JPanel {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                constructGUI();
            }
        });
    }

    private static void constructGUI() {
        JFrame frame = new JFrame("Testy");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.DARK_GRAY);
        centerPanel.setPreferredSize(new Dimension(100, 400));
        frame.add(centerPanel, BorderLayout.CENTER);

        Testy eastPanel = new Testy();
        frame.add(eastPanel, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }

    public Testy() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JButton button = new JButton("Button ...... 1");
        //button.setPreferredSize(...);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getMinimumSize().height));
        add(button);

        button = new JButton("Button 2");
        //button.setPreferredSize(...);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getMinimumSize().height));
        add(button);

        button = new JButton("Button ........... 3");
        //button.setPreferredSize(...);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getMinimumSize().height));
        add(button);

        JLabel label = new JLabel("Label");
        //label.setPreferredSize(...);
        label.setMaximumSize(new Dimension(Integer.MAX_VALUE, label.getMinimumSize().height));
        add(label);

        JTextField textField = new JTextField();
        //textField.setPreferredSize(...);
        textField.setMaximumSize(new Dimension(Integer.MAX_VALUE, textField.getMinimumSize().height));
        add(textField);

        button = new JButton("Button 4");
        //button.setPreferredSize(...);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getMinimumSize().height));
        add(button);

        // add(Box.createVerticalGlue());
    }
}