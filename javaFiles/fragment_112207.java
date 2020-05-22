import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawTest extends JPanel{

    //Shape doesn't have a location field - you'd have to keep track of  
    //this yourself if you're set on using the shape interface
    private Rectangle shape = new Rectangle(100, 100);
    // The location within the shape you clicked
    private int xOffset = 0; 
    private int yOffset = 0;
    // To indicate dragging is happening
    boolean isDragging = false;

    public DrawTest(){
        MouseAdapter listener = new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                // Starts dragging and calculates offset
                if(shape.contains(e.getPoint())){
                    isDragging = true;
                    xOffset = e.getPoint().x - shape.x;
                    yOffset = e.getPoint().y - shape.y;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Ends dragging
                isDragging = false;
            }


            @Override
            public void mouseDragged(MouseEvent e) {
                // Moves the shape - doesn't actually need to be a method
                // but is because you had it as one
                if(isDragging){
                    moveShape(e);
                }
            }

            private void moveShape(MouseEvent e) {
                Point newLocation = e.getPoint();
                newLocation.x -= xOffset;
                newLocation.y -= yOffset;
                shape.setLocation(newLocation);
                repaint();
            }
        };

        //Add a mouse mostion listener (for dragging) and regular listener (for clicking)
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    // So we have a play area to work with
    public Dimension getPreferredSize(){
        return new Dimension(400,300);
    }

    //Paints the shape
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.clearRect(0,0,getWidth(), getHeight());
        g.fillRect(shape.x, shape.y, shape.width, shape.height);
    }


    public static void main(String[] args)
    {

        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DrawTest());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}