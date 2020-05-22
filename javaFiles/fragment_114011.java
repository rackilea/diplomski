import java.awt.*;
import javax.swing.*;

public class TestGrid {
    public TestGrid() {
        final JFrame frame = new JFrame("Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(3, 3));

        for (int idx = 0; idx < 9; idx++) {
            JLabel label = new JLabel();
            label.setBackground(idx % 2 == 0 ? Color.WHITE : Color.BLACK);
            label.setOpaque(true);
            mainPanel.add(label);
        }
        mainPanel.setPreferredSize(new Dimension(200, 200));
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.add(new JLabel("Title", JLabel.CENTER), BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(new JButton("Start"));
        buttonsPanel.add(new JButton("Stop"));
        frame.add(buttonsPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestGrid();
            }
        });
    }
}