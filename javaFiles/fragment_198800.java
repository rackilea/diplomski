import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TimeUpdate
{
    public void makeGUI()
    {
        final JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JLabel l = new JLabel();

        class UpdateThread implements Runnable
        {
            // Boolean used to keep the update loop alive.
            boolean running = true;

            public void run()
            {
                // Typically want to have a way to get out of
                // a loop. Setting running to false will 
                // stop the loop.
                while (running)
                {
                    try
                    {
                        l.setText("Time: " +
                                System.currentTimeMillis());

                        Thread.sleep(50);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }

                // Once the run method exits, this thread
                // will terminate.
            }
        }

        // Start a new time update thread.
        final UpdateThread t = new UpdateThread();
        new Thread(t).start();

        final JButton b = new JButton("Stop");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                t.running = false;
            }
        });

        // Prepare the frame.
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(l, BorderLayout.CENTER);
        f.getContentPane().add(b, BorderLayout.SOUTH);
        f.setLocation(100, 100);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new TimeUpdate().makeGUI();
            }
        });
    }
}