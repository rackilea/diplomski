package javatestapp;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;

public class JavaTestApp extends TimerTask
{
    static int x = 100;
    static int y = 0;
    static int z = 0;
    static int Max = 255;
    static int height = 500;
    static int width = 500; 
    static JFrame frame;

    public static void main(String[] args)
    {
        InitFrame();
    }

    public static void incrementValues()
    {
        if (x < Max)
        {
           x ++;
        }
        else
        {
           x = 0;
           y ++;
        }

        if (y > Max)
        {
           y = 0;
           z ++;
        } 

        if (z > Max)
        {
          x = 0;
          y = 0;
          z = 0;
        }
    }

    public static void genImage()
    {
        Color color = new Color(x,y,z,255);
        frame.getContentPane().setBackground(color);
    }

    public static void InitFrame()
    {
        frame = new JFrame("Bildergenerator");
        frame.setSize(width,height);
        frame.setVisible(true);

        Timer timer = new Timer(true);
        TimerTask timerTask = new JavaTestApp();
        timer.scheduleAtFixedRate(timerTask, 0, 10);
    } 

    @Override
    public void run()
    {
        incrementValues();
        genImage();
    }
}