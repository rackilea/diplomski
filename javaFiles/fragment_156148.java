import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class ProgressBar extends JFrame
{
    private int c = 0;
    private Timer t;
    private JButton btn;
    private JProgressBar pBar;

    // 15 minutes in milliseconds
    private final int waitingTime = 15 * 60 * 1000;// 900000 milliseconds

    private final int delay = waitingTime / 100;// 9000 == 9 seconds

    public ProgressBar()
    {
        setLayout(new FlowLayout());

        // delay in milliseconds
        // inside the internal anonymous class we write the code we want the timer to execute each delay
        // Instead of 50 milliseconds, you just have to write delay
        t = new Timer(delay, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(c <= 100) pBar.setValue(++c);
            }
        });

        btn = new JButton("WAIT");

        // Adding an action listener: when you click the button, the timer starts
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                // starting the timer, which causes it to sending ActionEvents to its Listeners
                t.start();
            }
        });

        add(btn);

        pBar = new JProgressBar(0, 100);

        // Setting the initial value of the progress bar
        pBar.setValue(c);// c == 0

        // Showing a string progress bar
        pBar.setStringPainted(true);

        // adding a changeListener to the progress bar
        pBar.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e)
            {
                if(pBar.getValue() == 100)
                {
                    t.stop();
                    JOptionPane.showMessageDialog(null, "Your order is ready!");

                    c = 0;
                    pBar.setValue(c);// set the initial value of the progress bar to 0 again
                }
            }
        });

        add(pBar);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                try
                {
                    new ProgressBar();
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, "Fatal Error.");
                }
            }
        });
    }

}