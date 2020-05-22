import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FaceComponent2 extends JPanel
{
    protected void paintComponent(Graphics g)
    {
        UIDefaults uid = UIManager.getDefaults();
        Graphics2D g2d = (Graphics2D)g;
        Dimension d = this.getSize();

        g2d.setPaint(new GradientPaint(0, 0, uid.getColor("ToolBar.light"),
            0, d.height, uid.getColor("ToolBar.shadow"), true));
        g2d.fillRect(0, 0, d.width , d.height);

        g2d.setColor(uid.getColor("ToolBar.light"));
        g2d.drawLine(0, d.height-2, d.width, d.height-2);

        g2d.setColor(uid.getColor("ToolBar.highlight"));
        g2d.drawLine(0, d.height-1, d.width, d.height-1);
    }


    public static void main(String args[])
        throws Exception
    {
        JComponent face = new FaceComponent2();
        face.setLayout( new GridLayout(0, 1) );
        face.setPreferredSize( new Dimension(250, 250) );
        face.add( new JLabel("Line1") );
        face.add( new JLabel("Line2") );
        face.add( new JLabel("Line3") );

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add( face );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );

    }
}