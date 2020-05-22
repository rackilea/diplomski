import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
public class Test
{
    public static void main (String [] a) {
        SwingUtilities.invokeLater (new Runnable () {
            @Override public void run () {
                createAndShowGUI ();
            }
        });
    }
    private static void createAndShowGUI () {
        JFrame frame = new JFrame ("App");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setContentPane (new DrawPanel (Color.PINK, Color.WHITE));
        frame.pack ();
        // frame.setExtendedState (JFrame.MAXIMIZED_BOTH); // You can use this instruction to have full screen mode.
        frame.setLocationRelativeTo (null);
        frame.setVisible (true);
    }
}
class DrawPanel extends JPanel
{
    Color foregroundColor;

    public DrawPanel (Color backgroundColor, Color foregroundColor) {
        setBackground (backgroundColor);
        this.foregroundColor = foregroundColor;
    }
    @Override public Dimension getPreferredSize () {
        return new Dimension (400, 400);
    }
    @Override protected void paintComponent (Graphics g) {
        super.paintComponent (g);
        g.setColor (foregroundColor);
        g.setFont (new Font ("Arial", Font.PLAIN, 24));
        g.drawString ("This is a test.", 200, 200);
    }
}