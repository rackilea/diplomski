import java.awt.Dimension;

import javax.swing.JFrame;

public class JFrameExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(100, 100));
        frame.setVisible(true);
    }
}