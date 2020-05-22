import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class DashedBorder extends JPanel
{
    public DashedBorder()
    {
        //  Use an Icon in the MatteBorder

        JLabel label1 = new JLabel("Label Using a Matte Border");
        add(label1);

        Icon icon = new DashedLineIcon(Color.BLACK, 5, 1, 5, 0);
        Border matte = BorderFactory.createMatteBorder(1, 0, 0, 0, icon);
        label1.setBorder( matte );
        System.out.println(matte.getBorderInsets(label1));

        add(Box.createHorizontalStrut(100));
        //  Create a CompoundBorder using the DashedBorder

        JLabel label2 = new JLabel("Label Using a Dashed Border");
        add(label2);

        Border dashed = BorderFactory.createDashedBorder(null, 5, 5);
        Border empty = BorderFactory.createEmptyBorder(1, -1, -1, -1);
        Border compound = new CompoundBorder(empty, dashed);
        label2.setBorder( compound );
        System.out.println(compound.getBorderInsets(label2));

    }

    static public class DashedLineIcon implements Icon
    {
        private Color color;
        private int dashWidth;
        private int dashHeight;
        private int emptyWidth;
        private int emptyHeight;

        public DashedLineIcon(Color color, int dashWidth, int dashHeight, int emptyWidth, int emptyHeight )
        {
            this.color = color;
            this.dashWidth = dashWidth;
            this.dashHeight = dashHeight;
            this.emptyWidth = emptyWidth;
            this.emptyHeight = emptyHeight;
        }

        public int getIconWidth()
        {
            return dashWidth + emptyWidth;
        }

        public int getIconHeight()
        {
            return dashHeight + emptyHeight;
        }

        public void paintIcon(Component c, Graphics g, int x, int y)
        {
            g.setColor(color);
            g.fillRect(x, y, dashWidth, dashHeight);
        }
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("Dashed Border");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DashedBorder());
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