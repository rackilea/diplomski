import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;

public class ChartAndButtons extends JPanel {
    private static final long serialVersionUID = 1L;

    public ChartAndButtons() {
        JPanel mockChartPanel = createMockChart();
        int gap = 3;
        JPanel buttonPanel = new JPanel(new GridLayout(1, 0, gap, gap));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
        String[] buttonNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        for (String buttonName : buttonNames) {
            buttonPanel.add(new JButton(buttonName));
        }

        setLayout(new BorderLayout());
        add(mockChartPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_END);
    }

    // ignore this -- it simply creates a JPanel as a placeholder
    // for your real JFreeChart panel   
    private JPanel createMockChart() {
        JLabel label = new JLabel("Mock Chart");
        label.setFont(label.getFont().deriveFont(Font.BOLD, 60f));
        Color color = Color.ORANGE;
        JPanel mockChartPanel = new JPanel(new GridBagLayout());
        mockChartPanel.add(label);
        Border outsideBorder = BorderFactory.createLineBorder(color, 40);
        int eb = 80;
        Border insideBorder = BorderFactory.createEmptyBorder(eb, eb, eb, eb);
        mockChartPanel.setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        mockChartPanel.setBackground(color.brighter());

        return mockChartPanel;
    }

    private static void createAndShowGui() {
        ChartAndButtons mainPanel = new ChartAndButtons();

        JFrame frame = new JFrame("ChartAndButtons");
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