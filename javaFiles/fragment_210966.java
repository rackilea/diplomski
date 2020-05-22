import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CubeCalc  {
    public static void MakeTitlePage()
    {
       final JFrame window = new JFrame("Cubic Feet Calculator"); // Creates Frame (created first so the button can reference it for JOptionPane

       JButton b1 = new JButton("Start");
       b1.setBackground(Color.decode("#5A20DF"));
       b1.setForeground(Color.WHITE);
       //b1.setLayout(new GridBagLayout()); << unnecessary
       b1.setPreferredSize(new Dimension(150,50));
       b1.addActionListener(new ActionListener() { // action when button is pressed
            int pressCount=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(++pressCount) {
                    case 1:  JOptionPane.showMessageDialog(window, "Hey, stop pressing me!"); break;
                    case 2:  JOptionPane.showMessageDialog(window, "I said, stop pressing me!!!!"); break;
                    default: JOptionPane.showMessageDialog(window, "Aaaaaaaaargl!!!!"); break;
                }
            }
        });

        JButton b2 = new JButton("Information about the Developer");
        b2.setBackground(Color.decode("#23D123"));
        b2.setForeground(Color.BLACK);
        //b2.setLayout(new GridBagLayout()); << unnecessary
        b2.setPreferredSize(new Dimension(275,50));
        b2.addActionListener(new ActionListener() { // action when button is pressed
            int pressCount=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(++pressCount) {
                    case 1:  JOptionPane.showMessageDialog(window, "There is no information here!"); break;
                    case 2:  JOptionPane.showMessageDialog(window, "Stop asking me for information!!!!"); break;
                    default: JOptionPane.showMessageDialog(window, "Aaaaaaaaargl!!!!"); break;
                }
            }
        });

        GridBagConstraints blo = new GridBagConstraints(); 
        blo.fill = GridBagConstraints.HORIZONTAL;
        blo.gridx = 0;
        blo.gridy = 1;
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -//
        JPanel start = new JPanel(new GridBagLayout());
        start.setBackground(Color.BLACK);
        start.setPreferredSize(new Dimension(300,100));
        start.add(b1, blo);

        JPanel info = new JPanel(new GridBagLayout());
        info.setBackground(Color.BLACK);
        info.setPreferredSize(new Dimension(300,100));
        info.add(b2, blo);
//- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -//
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*  window.add(new JLabel(new ImageIcon("Harold.jpg")));*/
        window.add(start, BorderLayout.NORTH);
        window.add(info, BorderLayout.SOUTH);

        window.setLocationRelativeTo(null);
        window.setResizable(true);
        window.setBackground(Color.BLACK);
        window.pack(); //resizes to minimum possible frame size
        window.setVisible(true); //Sets the frame to be visible
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { // launch frame on the Event Dispatch Thread
            @Override
            public void run() {
                 MakeTitlePage();
            }
        });
    }
}