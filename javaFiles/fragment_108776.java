import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.*;

public class SimpleStepProcessing extends JPanel {
    public static final String[] STEPS = { "Step One", "Step Two", "Step Three", "Step Four",
            "Step Five", "Step Six", "Step Seven", "Step Eight", "Step Nine", "Step Ten" };
    private JLabel stepLabel = new JLabel("");
    private int stepCounter = 0;
    private JButton nextButton = new JButton("Next");

    public SimpleStepProcessing() {
        nextButton.addActionListener(e -> {
            stepCounter++;
            if (stepCounter < STEPS.length) {
                // advance program to the next step
                stepLabel.setText(STEPS[stepCounter]);
            }
        });

        stepLabel.setText(STEPS[stepCounter]);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 4, 4));
        topPanel.add(new JLabel("Current Step:"));
        topPanel.add(stepLabel);

        JPanel middlePanel = new JPanel(new GridBagLayout());
        middlePanel.add(nextButton);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.PAGE_START);
        add(middlePanel, BorderLayout.CENTER);

        setPreferredSize(new Dimension(200, 100));
    }

    private static void createAndShowGui() {
        SimpleStepProcessing mainPanel = new SimpleStepProcessing();

        JFrame frame = new JFrame("SimpleStepProcessing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}