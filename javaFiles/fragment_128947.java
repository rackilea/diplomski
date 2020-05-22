import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ShapeClicker {

    public ShapeClicker() {
        JFrame frame = new JFrame();
        frame.setTitle("Shape Clicker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        initComponents(frame);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        //create frame and components on EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShapeClicker();
            }
        });
    }

    private void initComponents(JFrame frame) {
        frame.add(new ShapePanel());
    }
}

//custom panel
class ShapePanel extends JPanel {

    private Shape rect = new Rectangle2D.Double(50, 100, 200, 100);
    private Shape cirlce = new Ellipse2D.Double(260, 100, 100, 100);
    private Dimension dim = new Dimension(450, 300);
    private final ArrayList<Shape> shapes;

    public ShapePanel() {
        shapes = new ArrayList<>();
        shapes.add(rect);
        shapes.add(cirlce);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                super.mouseClicked(me);
                for (Shape s : shapes) {

                    if (s.contains(me.getPoint())) {//check if mouse is clicked within shape

                        //we can either just print out the object class name
                        System.out.println("Clicked a "+s.getClass().getName());

                        //or check the shape class we are dealing with using instance of with nested if
                        if (s instanceof Rectangle2D) {
                            System.out.println("Clicked a rectangle");
                        } else if (s instanceof Ellipse2D) {
                            System.out.println("Clicked a circle");
                        }

                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        for (Shape s : shapes) {
            g2d.draw(s);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return dim;
    }
}