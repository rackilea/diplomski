import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class SpringLayout_cobination {

    // THE OBJECTS
    static JFrame frame;// The frame
    static JPanel panel;        // The container
    static JButton Button;      // Object

    // THE LayOuts
    static SpringLayout LayOut_Frame;
    static SpringLayout LayOut_panel;
    static Container contentPane;

    public static void main(String[] args) {

        // Start frame and componets
        frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(830, 420); 

        panel=new JPanel();
        Button=new JButton("ok");

        panel.add(Button);
        panel.setSize(new Dimension(100,100));
        frame.add(panel);

        // Set the layouts
        LayOut_Frame=new SpringLayout(); // Frame LayOut
        frame.setLayout(LayOut_Frame);
        contentPane=frame.getContentPane(); // Main Container of the frame

        LayOut_panel=new SpringLayout();
        panel.setLayout(LayOut_panel);
        LayOut_panel.putConstraint(SpringLayout.NORTH, contentPane,30,SpringLayout.NORTH, Button);
        LayOut_panel.putConstraint(SpringLayout.WEST, contentPane,30,SpringLayout.WEST , Button);

        SpringLayout.Constraints c = LayOut_Frame.getConstraints(panel);
        c.setWidth(Spring.constant(200));
        c.setHeight(Spring.constant(100));

        LayOut_Frame.putConstraint(SpringLayout.NORTH, panel,30,SpringLayout.NORTH, contentPane);
        LayOut_Frame.putConstraint(SpringLayout.WEST, panel,30,SpringLayout.WEST , contentPane);



        frame.setVisible(true);
    }

}