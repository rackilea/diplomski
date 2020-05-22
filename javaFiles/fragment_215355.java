import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * A class which implements a simple tile border.
 */
public class TileBorder extends AbstractBorder
{
    protected int thickness;
    protected Color shadowInner;
    protected Color shadowOuter;

    /**
     * Creates a tile border with the specified type and whose
     * colors will be derived from the background color of the
     * component passed into the paintBorder method.
     * @param thickness the type of tile for the border
     */
    public TileBorder(int thickness) {
        this.thickness = thickness;
    }

    /**
     * Creates a tile border with the specified type, highlight and
     * shadow colors.
     * @param thickness the type of tile for the border
     * @param shadow the color to use for the tile shadow
     */
    public TileBorder(int thickness, Color shadow)
    {
        this(thickness, shadow, shadow.brighter());
    }

    /**
     * Creates a tile border with the specified type, highlight and
     * shadow colors.
     *
     * @param thickness the type of tile for the border
     * @param shadowOuterColor the color to use for the tile outer shadow
     * @param shadowInnerColor the color to use for the tile inner shadow
     */
    public TileBorder(int thickness, Color shadowOuterColor, Color shadowInnerColor)
    {
        this(thickness);
        this.shadowOuter = shadowOuterColor;
        this.shadowInner = shadowInnerColor;
    }

    /**
     * Paints the border for the specified component with the specified
     * position and size.
     * @param c the component for which this border is being painted
     * @param g the paint graphics
     * @param x the x position of the painted border
     * @param y the y position of the painted border
     * @param width the width of the painted border
     * @param height the height of the painted border
     */
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
    {
        int h = height;
        int w = width;
        int t = thickness;
        int m = thickness / 2;

        Graphics2D g2d = (Graphics2D)g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.translate(x, y);

        //  Paint border on right/bottom of component

        Shape outer = new Rectangle(0, 0, w - 1, h - 1);
        Shape inner = new Rectangle(0, 0, w - t, h - t);

        Area border = new Area( outer );
        border.subtract( new Area(inner) );

        g2d.setColor(getShadowInnerColor(c));
        g2d.fill( border );

        // Highlight border edge

        g2d.setColor(getShadowOuterColor(c));

        g2d.draw( border );
        g2d.drawLine(0, 0, w - t, 0);
        g2d.drawLine(0, 0, 0, h - t);
        g2d.drawLine(w - t, h - t, w, h);

        //  Fill border edge with background color of parent component

        g2d.setColor( c.getParent().getBackground() );

        Polygon topRight = new Polygon();
        topRight.addPoint(w - t, 0);
        topRight.addPoint(w, 0);
        topRight.addPoint(w, m);
        g2d.fillPolygon(topRight);

        Polygon bottomLeft = new Polygon();
        bottomLeft.addPoint(0, h - t);
        bottomLeft.addPoint(0, h);
        bottomLeft.addPoint(m, h);
        g2d.fillPolygon(bottomLeft);

        //  Cleanup

        g2d.dispose();
    }

    /**
     * Reinitialize the insets parameter with this Border's current Insets.
     * @param c the component for which this border insets value applies
     * @param insets the object to be reinitialized
     */
    public Insets getBorderInsets(Component c, Insets insets)
    {
        insets.set(0, 0, thickness, thickness);
        return insets;
    }

    /**
     * Returns the inner shadow color of the tile border
     * when rendered on the specified component.  If no shadow
     * color was specified at instantiation, the shadow color
     * is derived from the specified component's background color.
     * @param c the component for which the shadow may be derived
     */
    public Color getShadowInnerColor(Component c)
    {
        Color shadow = getShadowInnerColor();
        return shadow != null ? shadow : c.getBackground().darker();
    }

    /**
     * Returns the outer shadow color of the tile border
     * when rendered on the specified component.  If no shadow
     * color was specified at instantiation, the shadow color
     * is derived from the specified component's background color.
     * @param c the component for which the shadow may be derived
     */
    public Color getShadowOuterColor(Component c)
    {
        Color shadow = getShadowOuterColor();
        return shadow != null ? shadow : c.getBackground().darker().darker();
    }

    /**
     * Returns the inner shadow color of the tile border.
     * Will return null if no shadow color was specified
     * at instantiation.
     */
    public Color getShadowInnerColor()
    {
        return shadowInner;
    }

    /**
     * Returns the outer shadow color of the tile border.
     * Will return null if no shadow color was specified
     * at instantiation.
     */
    public Color getShadowOuterColor()
    {
        return shadowOuter;
    }

    /**
     * Returns whether or not the border is opaque.
     */
    public boolean isBorderOpaque()
    {
        return true;
    }

    private static void createAndShowGUI()
    {
        Border tile = new TileBorder(6);
        JPanel panel = new JPanel( new FlowLayout(FlowLayout.LEFT, 0, 0) );

        for (int i = 0; i < 5; i++)
        {
            JButton button = new JButton();
            button.setPreferredSize( new Dimension(50, 100) );
            button.setBorder( tile );
            panel.add( button );
        }

        JLayeredPane layeredPane = new JLayeredPane();
        int locationX = 20;
        int locationY = 50;

        for (int i = 0; i < 5; i++)
        {
            JButton button = new JButton();
            button.setSize( new Dimension(50, 100) );
            button.setLocation(locationX, locationY);
            button.setBorder( tile );
            panel.add( button );
            layeredPane.add(button, new Integer(i));
            locationX += 6;
            locationY -= 6;
        }

        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel, BorderLayout.PAGE_START);
        frame.add(layeredPane, BorderLayout.CENTER);
        frame.setSize(300, 300);
        frame.setLocationByPlatform( true );
        frame.setVisible( true );
    }

    public static void main(String[] args) throws Exception
    {
        java.awt.EventQueue.invokeLater( () -> createAndShowGUI() );
    }
}