import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame f = new JFrame("Example");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.getContentPane().add(getPanel());
                f.pack();
                f.setVisible(true);
            }
        });
    }

    private static JPanel getPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Top"), BorderLayout.NORTH);
        panel.add(new JLabel("Center"), BorderLayout.CENTER);
        panel.add(new JLabel("Bottom"), BorderLayout.SOUTH);
        panel.setPreferredSize(new Dimension(400, 300));
        return panel;
    }
}