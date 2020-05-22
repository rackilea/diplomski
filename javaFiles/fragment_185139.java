import javax.swing.*;
import java.awt.*;

public class GWindow extends Canvas {
    public GWindow() {
        JFrame frame = new JFrame("Dungeon120");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set layout to SpringLayout
        SpringLayout layout = new SpringLayout();
        frame.setLayout(new SpringLayout());
        this.setSize(1000, 650);
        frame.add(this);
        JTextField listener = new JTextField();
        listener.addKeyListener(new GInputs());
        //position it offscreen
        layout.putConstraint(SpringLayout.SOUTH, listener, 0, SpringLayout.NORTH, frame.getContentPane());
        frame.add(listener);
        frame.pack();
        frame.setVisible(true);
        //set focus to JTextField
        listener.requestFocusInWindow();
        this.setBackground(Color.black);
    }
}