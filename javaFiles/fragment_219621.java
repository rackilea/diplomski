import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class RobotPlayback extends JFrame implements KeyListener, ActionListener
{
    JTextField textField1;
    JTextField textField2;
    List playback = new ArrayList();

    public RobotPlayback()
    {
        textField1 = new JTextField(30);
        textField1.addKeyListener( this );
        getContentPane().add(textField1, BorderLayout.NORTH);
//
        JButton button = new JButton("Playback");
        button.addActionListener( this );
        button.setFocusable(false);
        getContentPane().add(button);
//
        textField2 = new JTextField(30);
        getContentPane().add(textField2, BorderLayout.SOUTH);
    }

    public void keyPressed(KeyEvent e)
    {
        playback.add(e);
    }

    public void keyReleased(KeyEvent e)
    {
        playback.add(e);
    }

    public void keyTyped(KeyEvent e) {}

    public void actionPerformed(ActionEvent e)
    {
        Thread playback = new Thread()
        {
            public void run()
            {
                 playback();
            }
        };
        playback.start();
    }

    private void playback()
    {
        textField2.requestFocus();

        try
        {
            Robot robot = new Robot();
            robot.setAutoDelay( 200 );

            for (int i = 0; i < playback.size();i++)
            {
                KeyEvent event = (KeyEvent)playback.get(i);

                if (event.getID() == KeyEvent.KEY_PRESSED)
                    robot.keyPress( event.getKeyCode() );
                else
                    robot.keyRelease( event.getKeyCode() );
            }
        }
        catch(Exception exc)
        {
            System.out.println(exc);
        }

        setVisible(true);
        playback = new ArrayList();
        textField1.requestFocus();
    }

    public static void main(String[] args)
        throws Exception
    {
        JFrame frame = new RobotPlayback();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
     }
}