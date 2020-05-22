import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.FlatteningPathIterator;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SharpiePaintTest
{
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }    

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new SharpiePaintTestPanel());
        f.setSize(1100,600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

class SharpiePaintTestPanel extends JPanel
{
    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;
        g.setColor(Color.BLACK);

        Path2D path = new Path2D.Double();
        path.moveTo(300,300);
        path.curveTo(400, 400, 400, 300, 300, 200);

        g.setStroke(new ShapeStroke(new Rectangle2D.Double(0,0,3,15), 3.0f));
        g.draw(path);
    }
}

// Based on http://www.jhlabs.com/java/java2d/strokes/ShapeStroke.java,
// only slightly simplified
class ShapeStroke implements Stroke {
    private Shape shape;
    private float advance;
    private static final float FLATNESS = 1;

    public ShapeStroke(Shape shape, float advance ) {
        this.advance = advance;
        Rectangle2D bounds = shape.getBounds2D();
        this.shape = AffineTransform.getTranslateInstance(
            -bounds.getCenterX(), -bounds.getCenterY()).createTransformedShape(shape);
    }

    @Override
    public Shape createStrokedShape( Shape shape ) {
        GeneralPath result = new GeneralPath();
        PathIterator it = new FlatteningPathIterator( shape.getPathIterator( null ), FLATNESS );
        float points[] = new float[6];
        float moveX = 0, moveY = 0;
        float lastX = 0, lastY = 0;
        float thisX = 0, thisY = 0;
        int type = 0;
        float next = 0;
        while (!it.isDone() ) {
            type = it.currentSegment( points );
            switch( type ){
            case PathIterator.SEG_MOVETO:
                moveX = lastX = points[0];
                moveY = lastY = points[1];
                result.moveTo( moveX, moveY );
                next = 0;
                break;

            case PathIterator.SEG_CLOSE:
                points[0] = moveX;
                points[1] = moveY;
                // Fall into....

            case PathIterator.SEG_LINETO:
                thisX = points[0];
                thisY = points[1];
                float dx = thisX-lastX;
                float dy = thisY-lastY;
                float distance = (float)Math.sqrt( dx*dx + dy*dy );
                if ( distance >= next ) {
                    float r = 1.0f/distance;
                    while (distance >= next ) {
                        float x = lastX + next*dx*r;
                        float y = lastY + next*dy*r;
                        AffineTransform t = new AffineTransform();
                        t.setToTranslation( x, y );
                        result.append( t.createTransformedShape(this.shape), false );
                        next += advance;
                    }
                }
                next -= distance;
                lastX = thisX;
                lastY = thisY;
                break;
            }
            it.next();
        }

        return result;
    }

}