import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClosestPairOfPoints extends JFrame {
// Create a canvas
private Circle canvas = new Circle();

public ClosestPairOfPoints() {
    // Add canvas and panel
    add(canvas, BorderLayout.CENTER);

    canvas.addMouseListener(new MouseAdapter() {
        @Override
        // Handle mouse clicked event
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1){
                canvas.createCircle(e.getX(), e.getY());
            }else if (e.getButton() == MouseEvent.BUTTON2){
                System.out.println("Try again with the left button");
            }else if (e.getButton() == MouseEvent.BUTTON3){
                System.out.println("Try again with the left button");
          }
        }
    });

}

public static void main(String[] args) {
    JFrame frame = new ClosestPairOfPoints();
    frame.setTitle("Closest pair of Ppoints");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}

static class Circle extends JPanel { // Inner class
    private int x;
    private int y;
    private int radius = 10; // Default circle radius

    // Create a circle
    public void createCircle(int x, int y) {
    this.x = x;
    this.y = y;
    repaint();
    }

    // paint the component
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawOval(x, y, radius, radius);

    }
}
}