import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
* A couple of notes about long running tasks and GUI updates:
*
* 1) all GUI painting should be done in the event thread
* 2) GUI painting is not done until the event thread processing is done
*
* This means that long running code (database access, file processing ...)
* should not be done in the event thread. A new thread can be created for
* these tasks.
*
* Most Swing methods are not thread safe. If the long running task needs
* to update the GUI for any reason then the SwingUtilities class
* should be used to add code to the event thread.
*
* See the Swing tutorial on "Using Threads" for more information
* http://java.sun.com/docs/books/tutorial/uiswing/misc/threads.html
*/
public class InvokeLaterTest extends JFrame
    implements ActionListener, Runnable
{
    JLabel status;
    JButton eventThread;
    JButton newThread;
    JButton stop;
    Thread thread;
    int i;
    boolean stopProcessing;

    public InvokeLaterTest()
    {
        status = new JLabel( "Ready to Process:" );
        status.setHorizontalAlignment( JLabel.CENTER );
        getContentPane().add(status, BorderLayout.NORTH);

        eventThread = new JButton( "Start in Event Thread" );
        eventThread.addActionListener( this );
        getContentPane().add(eventThread, BorderLayout.WEST);

        newThread = new JButton( "Start in New Thread" );
        newThread.addActionListener( this );
        getContentPane().add(newThread, BorderLayout.EAST);

        stop = new JButton( "Stop Processing" );
        stop.addActionListener( this );
        getContentPane().add(stop, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e)
    {
        //  Code is executing in Event thread so label will not be updated
        //  and the Stop button will not be enabled.

        if (e.getSource() == eventThread)
        {
            stopProcessing = false;
            run();
        }

        //  Code is executing in a new thread so label will be updated

        else if (e.getSource() == newThread)
        {
            stopProcessing = false;
            thread = new Thread( this );
            thread.start();
        }
        else
        {
            stopProcessing = true;
            status.setText("Processing Stopped");
            setButtons( true );
        }
    }

    public void run()
    {
        setButtons( false );

        for (i = 1; i < 10; i++)
        {
            if ( stopProcessing ) return;

            System.out.println("ProcessingFile: " + i);

            // SwingUtilities makes sure code is executed in the event thread.

            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    status.setText("Processing File: " + i);
                    status.paintImmediately(status.getBounds());
                }
            });

            // simulate log running task

            try { Thread.sleep(1000); }
            catch (Exception e) {}
        }

        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                status.setText("Finished Processing");
                setButtons( true );
            }
        });
    }

    private void setButtons(boolean value)
    {
        eventThread.setEnabled( value );
        newThread.setEnabled( value );
    }

    public static void main(String[] args)
    {
        JFrame frame = new InvokeLaterTest();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.show();
    }
}