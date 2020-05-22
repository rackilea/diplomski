import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class MovingSquare
{
    private int x = 0;
    private int y = 100;
    private final int WIDTH = 100;
    private final int HEIGHT = 100;
    private Random random;
    private CustomPanel canvas;
    private Timer drawingTimer;
    private ActionListener timerAction = 
        new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            /*if ((x + WIDTH > 500) && (y + HEIGHT > 500))
            {
                x = random.nextInt(500 - WIDTH);
                canvas.setValues(x, y, Color.BLUE);
            }
            else
            {
                x += WIDTH;
                canvas.setValues(x, y, Color.BLUE);
            }*/
            x = random.nextInt(500 - WIDTH);
            y = random.nextInt(500 - HEIGHT);
            canvas.setValues(x, y, new Color(
                random.nextFloat(), random.nextFloat()
                , random.nextFloat(), random.nextFloat()));
        }
    };

    public MovingSquare()
    {
        random = new Random();
    }

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