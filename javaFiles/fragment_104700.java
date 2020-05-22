import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class IntersectingRectangles extends JPanel
{
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        Dimension d = getSize();
        int width = d.width * 3 / 4;
        int height = d.height * 3 / 4;

        Rectangle r1 = new Rectangle(0, 0, width, height);
        g2d.setColor( Color.BLUE );
        g2d.fill( r1 );

        Rectangle r2 = new Rectangle(d.width - width, d.height - height, width, height);
        g2d.setColor( Color.YELLOW );
        g2d.fill( r2 );

        //  Specific solution when using Rectangles only

        Rectangle r3 = r1.intersection(r2);
        g2d.setColor(Color.GREEN);
        g2d.fill(r3);
/*
        //  For a more generic solution using any Shape

        Area area = new Area(r1);
        area.intersect( new Area(r2) );
        g2d.setColor(Color.GREEN);
        g2d.fill(area);
*/
        g2d.dispose();

    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(300, 300);
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("Intersecting Rectangles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new IntersectingRectangles());
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}