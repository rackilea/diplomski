import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class SO46085131 extends JPanel {

    private final Dimension LAYER_SIZE = new Dimension(300, 300);

    private Point prevPoint = null;
    private BufferedImage paintLayer;
    private Graphics paintLayerGraphics;

    public SO46085131(){
        setBackground(Color.black);
        // create our layer that we will paint onto
        paintLayer = new BufferedImage(LAYER_SIZE.width, LAYER_SIZE.height, BufferedImage.TYPE_INT_ARGB);

        // get our graphics for the painting layer and fill in a background cause thats cool
        paintLayerGraphics = paintLayer.getGraphics();
        paintLayerGraphics.setColor(Color.red);
        paintLayerGraphics.fillRect(0, 0, paintLayer.getWidth(), paintLayer.getHeight());

        setBackground(Color.WHITE);
        // listen for drag events, then draw
        // TODO: You should listen for mouse up and down events instead of dragging so you can clear your previous point
        // TODO: Big boy bugs here! for you to fix
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // if we moved the mouse previously draw a line from our prev point to our current position
                if(prevPoint != null) {
                    paintLayerGraphics.setColor(Color.black);
                    paintLayerGraphics.drawLine(prevPoint.x, prevPoint.y, e.getX(), e.getY());
                    repaint();
                }
                // store previous point
                prevPoint = e.getPoint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw our sweet painting layer ontop of our component.
        g.drawImage(paintLayer, 0, 0, this);
    }

    public static void main(String [] args) {
        // just new up a sample jframe to display our stuff on 
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SO46085131());
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}