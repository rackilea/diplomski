import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MovingSquare
{
    private int x = 0;
    private int y = 100;
    private final int WIDTH = 100;
    private CustomPanel canvas;
    private Timer drawingTimer;
    private ActionListener timerAction = 
        new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            if ((x + WIDTH == 500))
            {
                x = 0;
                canvas.setValues(x, y, Color.BLUE);
            }
            else
            {
                x += WIDTH;
                canvas.setValues(x, y, Color.BLUE);
            }
        }
    };

    private void displayGUI()
    {
        JFrame frame = new JFrame("Moving Sqaure");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        canvas = new CustomPanel();
        frame.setContentPane(canvas);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        drawingTimer = new Timer(1000, timerAction);
        drawingTimer.start();
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new MovingSquare().displayGUI();
            }
        });
    }
}

class CustomPanel extends JPanel
{
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private final int WSQUARE = 100;
    private final int HSQUARE = 50;

    private int x = 0;
    private int y = 100;
    private Color cSquare = Color.BLUE;

    /* 
     * This is where we updating the state
     * of different variables needed, and
     * thus calling repaint.
     */
    public void setValues(int x, int y, Color color)
    {
        cSquare = color;
        repaint(this.x, this.y, WSQUARE, HSQUARE);
        this.x = x;
        this.y = y;
        repaint(x, y, WSQUARE, HSQUARE);
    }

    /*
     * Always make this one customary
     * habbit, to override this method
     * when you extending a JComponent.
     */
    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(WIDTH, HEIGHT));
    }

    /* 
     * This is where the actual Painting
     * Portion of the whole thingy will
     * reside. Better is, not to put any
     * calculations in this part, just
     * update the state at some another
     * location and convey it to repaint
     * as needed.
     */
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(cSquare);
        g.fillRect(x, y, WSQUARE, HSQUARE);
    }
}