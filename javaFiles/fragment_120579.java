import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {

    public static void main(String[] args) {
        FrameTest1 test_frame = new FrameTest1();
        test_frame.setContentString("I WANT TO DRAW THIS STRING");
    }

}

class FrameTest1 extends JFrame {
    private static final long serialVersionUID = 1L;

    Painting painting = new Painting();

    public FrameTest1() {
        JFrame gui = new JFrame();
        gui.setTitle("Test Title");
        gui.setSize(400, 400);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = gui.getContentPane();
        pane.setLayout(new GridLayout(1, 1));

        pane.add(painting);
        gui.setVisible(true);

    }

    public void setContentString(String value) {
        painting.test_string = value;
    }
}

class Painting extends JPanel {
    private static final long serialVersionUID = 1L;
    String test_string;

    public Painting() {
        setBackground(Color.WHITE);
        this.test_string = "TEMP STRING FROM PANEL";
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.drawString(test_string, 20, 20);
    }
}