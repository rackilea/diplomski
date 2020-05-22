import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ShapeSelect extends JPanel {

    private final Shape firstShape = new Rectangle2D.Float(60, 40, 70, 70);
    private final Shape secondShape = new Ellipse2D.Float(30, 30, 90, 50);
    private Shape selected = null;

    public ShapeSelect () {
        // set up the component
        setPreferredSize(new Dimension(200, 200));
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override public void mouseDragged (MouseEvent event) {
                selectShapeUnder(event.getX(), event.getY());
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override public void mousePressed (MouseEvent event) {
                selectShapeUnder(event.getX(), event.getY());
            }
        });
    }

    // draw our shapes, selected shape is yellow.
    @Override protected void paintComponent (Graphics g) {
        Graphics2D graphics = (Graphics2D)g;
        graphics.setColor((selected == firstShape) ? Color.YELLOW : Color.RED);
        graphics.fill(firstShape);
        graphics.setColor((selected == secondShape) ? Color.YELLOW : Color.GREEN);
        graphics.fill(secondShape);
    }

    // updates 'selected' based on x,y coordinate and redraws component on change.
    public void selectShapeUnder (int x, int y) {
        Shape oldSelected = selected;
        // note that since second shape is draw on top of first, we give second preference.
        // for overlapping shapes the selection should be consistent with the gui display.
        if (secondShape.contains(x, y))
            selected = secondShape;
        else if (firstShape.contains(x, y))
            selected = firstShape;
        else
            selected = null;
        if (selected != oldSelected)
            repaint();
    }


    public static final void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override public void run () {
                JFrame frame = new JFrame("Shape Select");
                frame.getContentPane().add(new ShapeSelect(), BorderLayout.CENTER);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }


}