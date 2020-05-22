import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.*;

public class MouseScrollRobot extends JFrame
{

    JTextArea ta;
    boolean scrolledAway = false;
    Robot robot;
    boolean started = false;
    public void createAndShowGUI() 
    {
        setTitle("Robot Demonstration");
        JPanel panel = new JPanel();
        ta = new JTextArea();   
        StringBuilder sBuilder = new StringBuilder();
        try
        {
            robot = new Robot();
            BufferedReader bfr = new BufferedReader(new FileReader("MouseScrollRobot.java"));
            String line = null ;
            while ((line = bfr.readLine()) !=null)
            {
                sBuilder.append(line+"\n");
            }
        }
        catch (Exception ex){ex.printStackTrace();}
        ta.setText(sBuilder.toString());
        JScrollPane jsp = new JScrollPane(ta);
        final Timer timer = new Timer(100, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent evt)
            {
                try
                {
                    robot.mouseMove((getLocationOnScreen().x + getWidth()) / 2 , (getLocationOnScreen().y + getHeight()) / 2);//Move mouse pointer to the Component which you want to scroll
                    ta.requestFocus();
                    robot.setAutoDelay(100);
                    if (!scrolledAway)
                    {
                        setTitle("Scrolling up");
                        robot.mouseWheel(-40);
                    }
                    else
                    {
                        setTitle("Scrolling Down");
                        robot.mouseWheel(40);
                    }
                    scrolledAway = !scrolledAway;
                    setTitle("Scrolled");
                }catch (Exception ex){ex.printStackTrace();}
            }
        });
        timer.setRepeats(true);
        timer.start();
        getContentPane().add(jsp);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
  }

  public static void main(String args[]) 
  {
    SwingUtilities.invokeLater( new Runnable()
    {
        @Override
        public void run()
        {
            MouseScrollRobot msr = new MouseScrollRobot();
            msr.createAndShowGUI();
        }
    });
  }
}