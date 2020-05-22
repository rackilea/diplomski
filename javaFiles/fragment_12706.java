import javax.swing.*;
import java.awt.*;

public class FontSizeDemo {
    private static void createAndShowUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int y = 0;
                for(int size = 4; size <= 24; size += 2) {
                    g.setFont(new Font("Arial", Font.BOLD, size));
                    g.drawString("Name", 0, y);
                    int heightOfFont = g.getFontMetrics().getHeight();
                    y += heightOfFont;
                }
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 300); 
            }
        };

        frame.add(panel);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}