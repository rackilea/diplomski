import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class StopWatch implements ActionListener {

    JLabel jlab;
    long start;  // holds the start time in milliseconds

    StopWatch() {
        // Create a new JFrame Container.
        JFrame jfrm = new JFrame("A Simple StopWatch");

        // Specify the FlowLayout for the layout manager.
        jfrm.setLayout(new FlowLayout());

        // Give the frame an initial size.
        jfrm.setSize(230,90);

        // Terminates the program when the user closes the application.
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make two buttons
        JButton jbtnStart = new JButton("Start");
        JButton jbtnStop = new JButton("Stop");

        // Add action listeners. 
        jbtnStart.addActionListener(this);
        jbtnStop.addActionListener(this);

        // Add the buttons to the content pane
        jfrm.add(jbtnStart); 
        jfrm.add(jbtnStop);

        // Create a text-based label
        jlab = new JLabel("Press Start to begin timing.");

        // Add the label
        jfrm.add(jlab);

        jfrm.setVisible(true);

    }

    // Handle button events
    public void actionPerformed(ActionEvent ae) {
        Calendar cal = Calendar.getInstance();  // get current system time

        if (ae.getActionCommand().equals("Start")) { 
            start = cal.getTimeInMillis();
            jlab.setText("Stopwatch is Running...");
        }

        else
            // Compute the elapsed time.
            jlab.setText("Elapsed time is "+(double)(cal.getTimeInMillis() - start)/1000);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
        public void run() { new StopWatch(); }
        });
    }

}