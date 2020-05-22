import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class ButtonsLeftAndRight {
    private JFrame frame;
    private JPanel bottomPane;
    private JPanel centerPane;
    private JButton button1;
    private JButton button2;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ButtonsLeftAndRight()::createAndShowGui);
    }

    public void createAndShowGui() {
        frame = new JFrame(getClass().getSimpleName());

        bottomPane = new JPanel();
        bottomPane.setLayout(new BoxLayout(bottomPane, BoxLayout.LINE_AXIS));

        button1 = new JButton("Button1");
        button2 = new JButton("Button2");

        bottomPane.add(button1);
        bottomPane.add(Box.createHorizontalGlue());
        bottomPane.add(button2);

        frame.add(bottomPane, BorderLayout.SOUTH);
        JButton b1 = new JButton("A");
        JButton b2 = new JButton("B");
        JButton b3 = new JButton("C");

        centerPane = new JPanel();
        centerPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPane.add(b1, gbc);

        gbc.gridx = 2;
        centerPane.add(new JLabel("Label 1"), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        centerPane.add(b2, gbc);

        gbc.gridx = 2;
        centerPane.add(new JLabel("Label 2"), gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        centerPane.add(b3, gbc);

        gbc.gridx = 2;
        centerPane.add(new JLabel("Label 3"), gbc);

        gbc.gridx = 1;
        gbc.gridy++;
        centerPane.add(new JLabel("Centered Label"), gbc);

        frame.add(centerPane, BorderLayout.CENTER);
        frame.add(bottomPane, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}