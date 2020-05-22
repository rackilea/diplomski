import java.awt.*;
import javax.swing.*;

public class GWindow extends Canvas {
    public GWindow() {
        frame = new JFrame("Dungeon120");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 650);
        frame.add(this);
        JTextField listener = new JTextField();
        listener.addKeyListener(new GInputs());
        //add it to the frame using any layout of your choice
        this.add(listener);
        frame.pack();
        frame.setVisible(true);
        //set focus to JTextField
        listener.requestFocusInWindow();
        this.setBackground(Color.black);
    }
}