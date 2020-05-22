import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class LatihanEvent2 implements ActionListener {

    private JButton buttonRed = new JButton("Red");
    private JButton buttonGreen = new JButton("Green");
    private JButton buttonBlue = new JButton("Blue");
    JPanel ui = new JPanel(new BorderLayout(5, 5));

    public LatihanEvent2() {
        JFrame frame = new JFrame("Contoh Event");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // quick and dirty way to provide space in a GUI
        ui.add(new JLabel(new ImageIcon(
                new BufferedImage(300, 300, BufferedImage.TYPE_INT_ARGB))));

        JPanel panel = new JPanel();
        // border layout constraints are irrelevant to a flow layout!
        //ui.add(buttonRed, BorderLayout.WEST);
        panel.add(buttonRed);
        panel.add(buttonGreen);
        panel.add(buttonBlue);

        //Inner Class
        ListenerRed clickListener = new ListenerRed();
        buttonRed.addActionListener(clickListener);

        //Anonymous Class
        buttonGreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ui.setBackground(Color.GREEN);
            }
        });

        //Derived Class
        buttonBlue.addActionListener(this); //Step 2

        ui.add(panel, BorderLayout.PAGE_END);

        frame.setContentPane(ui);

        frame.pack();
        //frame.show();  // Deprecated!
        frame.setVisible(true); // should be last..
    }

    public static void main(String[] args) {
        // The GUI should be created and updated on the EDT.  E.G.
        Runnable r = new Runnable() {

            @Override
            public void run() {
                new LatihanEvent2();
            }
        };
        // Here is the iomportant part of actually 
        // starting that runnable on the EDT..
        SwingUtilities.invokeLater(r);
    }

    //Inner Class
    class ListenerRed implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            ui.setBackground(Color.RED);
        }
    }

    //Derived Class
    public void actionPerformed(ActionEvent e) {
        ui.setBackground(Color.BLUE);
    }
}