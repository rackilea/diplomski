import java.awt.*;
import javax.swing.*;

public class FanApplet extends JApplet
{
    private int angle1 = -15;
    private int angle2 = 75;
    private int angle3 = 165;
    private int angle4 = 255;

    public FanApplet()
    {
        add(new FanControl());
    }

    class FanControl extends JPanel
    {
        public FanControl()
        {
            // by setting a BorderLayout and adding a component to the CENTER
            // (default if no constraint specified) the child component will
            // be stretched to fill the available space.
            setLayout(new BorderLayout());
            add(new Fan());
        }
    }

    class Fan extends JPanel
    {
        public Fan()
        {
            //this.setSize(600, 400);
            Runnable spinner = new SpinFan();

            Thread thread1 = new Thread(spinner);
            thread1.start();
        }


        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            g.drawOval(200, 150, 150, 150);
            g.fillArc(210, 160, 130, 130, angle1, 30);
            g.fillArc(210, 160, 130, 130, angle2, 30);
            g.fillArc(210, 160, 130, 130, angle3, 30);
            g.fillArc(210, 160, 130, 130, angle4, 30);
        }
    }

    class SpinFan implements Runnable
    {
        @Override
        public void run()
        {
            try
            {
                while(true)
                {
                    angle1 = (angle1 + 1) % 360;
                    angle2 = (angle2 + 1) % 360;
                    angle3 = (angle3 + 1) % 360;
                    angle4 = (angle4 + 1) % 360;

                    System.out.println(angle1 + " " + angle2 + " " + angle3 + " " + angle4);

                    // This ensures that repaint() is called on the EDT.
                    Runnable r = new Runnable() {
                        public void run() {
                            repaint();
                        }
                    };
                    SwingUtilities.invokeLater(r);

                    Thread.sleep(10);
                }
            }
            catch(InterruptedException ex)
            {
                System.out.println("Problem while putting thread to sleep.");
            }
        }
    }
}