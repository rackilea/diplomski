import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DrawingClass {
    private JPanel contentPane;
    private JFrame frame;
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new DrawingClass().createAndShowGUI());
    }

    public void createAndShowGUI() {
        frame = new JFrame(getClass().getSimpleName());
        Line line = new Line();
        frame.add(line);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    class Line extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.fillRect(10, 10, 15, 12);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(480, 640);
        }
    }
}