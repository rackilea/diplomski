import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.util.Random;

public class SwingPaintDemo3 {

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createAndShowGUI();
        }
    });
}

private static void createAndShowGUI() {
    System.out.println("Created GUI on EDT? "+
    SwingUtilities.isEventDispatchThread());
    JFrame f = new JFrame("Swing Paint Demo");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(new MyPanel());
    f.pack();
    f.setVisible(true);
}
}

class MyPanel extends JPanel {

private int squareX = 50;
private int squareY = 50;
private int squareW = 20;
private int squareH = 20;
Image img;
Random r = new Random();

public MyPanel() {
    img = new BufferedImage(40,40,BufferedImage.TYPE_INT_RGB);

    setBorder(BorderFactory.createLineBorder(Color.black));

    addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            img = new BufferedImage(
                r.nextInt(getWidth())+1,
                r.nextInt(getHeight())+1,
                BufferedImage.TYPE_INT_RGB);
            moveSquare(e.getX(),e.getY());
        }
    });
}

private void moveSquare(int x, int y) {
    int OFFSET = 1;
    if ((squareX!=x) || (squareY!=y)) {
        squareX=x;
        squareY=y;
        repaint();
    }
}


public Dimension getPreferredSize() {
    return new Dimension(250,200);
}

protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.drawImage(img, 0, 0, null);
    g.drawString("This is my custom Panel!",10,20);
    g.setColor(Color.RED);
    g.fillRect(squareX,squareY,squareW,squareH);
    g.setColor(Color.BLACK);
    g.drawRect(squareX,squareY,squareW,squareH);
}
}