import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyGui implements ActionListener {  //********
    protected JLabel label = new JLabel("Hello");
    protected JButton button = new JButton("Click me");

    public MyGui() {
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 100, 500, 300);


        JPanel panel = new JPanel();
        panel.add(label);
        button.addActionListener(this);  //**********
        panel.add(button);

        Container cpane = frame.getContentPane();
        cpane.add(panel);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {   //**************
        System.out.println("boo");
        label.setText("The button was clicked!");
    }

}

public class SwingProg {
    private static void createAndShowGUI() {
        new MyGui();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}