import java.awt.*;
import javax.swing.*;

public class Test {

    public static void main(String[] args) {
        Test gui = new Test();
        gui.setUpFrame();
    }

    public void setUpFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Images should be in this program");
        frame.setSize(600, 300);
        JPanel oval = new oval();
        frame.setContentPane(oval);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public class oval extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(70, 70, 100, 100);
        }
    }

}