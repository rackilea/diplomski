import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;

public class RoundedBorderContainer extends JPanel implements Border
{
    private boolean componentWasOpaque;

    public RoundedBorderContainer(JComponent component)
    {
        setLayout( new BorderLayout() );
        add( component );

        componentWasOpaque = component.isOpaque();
        component.setOpaque( false );
        setOpaque( false );

        setBorder( this );
    }

    @Override
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        int arc = 20;
        int width = getWidth();
        int height = getHeight();

        RoundRectangle2D borderRect = new RoundRectangle2D.Double(0, 0, width, height, arc, arc);
        g2.setClip(borderRect);

        super.paint(g);
        super.paintBorder(g);

        g2.setClip( null );
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if (componentWasOpaque)
        {
            g.setColor(getComponent(0).getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    @Override
    public Insets getBorderInsets(Component c)
    {
        return new Insets(1, 1, 1, 1);
    }

    @Override
    public boolean isBorderOpaque()
    {
        return false;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
    {
        Graphics2D g2 = (Graphics2D) g;

        int arc = 20;
        RoundRectangle2D borderRect = new RoundRectangle2D.Double(0, 0, width - 1, height - 1, arc, arc);
        Rectangle fullRect = new Rectangle(0, 0, width, height);

        Area borderArea = new Area(borderRect);
        borderArea = new Area(borderRect);
        Area parentArea = new Area(fullRect);

        g2.setColor(Color.RED);

        g2.draw(borderArea);
    }

    private static void createAndShowGUI()
    {
        JLabel label = new JLabel( new ImageIcon("grass.jpg") );
        label.setLayout( new GridBagLayout() );

        JPanel panel = new JPanel();
        panel.setPreferredSize( new Dimension(100, 100) );
        panel.setBackground( Color.BLACK );

//        JLabel panel = new JLabel( new ImageIcon("???") );

        RoundedBorderContainer rbc = new RoundedBorderContainer(panel);
        label.add(rbc);

        JFrame frame = new JFrame("Rounded Border");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( label );
        frame.setLocationByPlatform( true );
//        frame.pack();
        frame.setSize(400, 400);
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