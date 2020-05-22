package windows;

import java.awt.*;
import javax.swing.*;

public abstract class WindowTemplate extends JFrame {

/**
 * Create the GUI and show it. For thread safety, this method should be
 * invoked from the event-dispatching thread.
 */
public WindowTemplate () {

    JFrame myFrame = new JFrame("My first window");
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myFrame.setVisible(true);
    myFrame.setSize(550, 450);
    myFrame.setLocationRelativeTo(null);

    // JLabel emptyLabel = new JLabel("");
    // emptyLabel.setPreferredSize(new Dimension(550, 450));

    // myFrame.getContentPane().setLayout(new CardLayout());
    // myFrame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

    // myFrame.pack();

}

}