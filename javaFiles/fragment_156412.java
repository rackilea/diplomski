import java.awt.*;
import javax.swing.*;

public class Swing{
    JFrame frame;
    Panel panel;
    public static void main(String [] args){
        Swing a  = new Swing();
        a.go();
    }
    public void go(){
        frame  = new JFrame();
        panel = new Panel();
        panel.setPreferredSize(new Dimension(5000, 5000));
        JScrollPane scroll = new JScrollPane(panel);
        frame.add(scroll);
        frame.pack();
        frame.setVisible(true);
    }

    class Panel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);  // VERY IMPORTANT!
            Graphics2D a = (Graphics2D)g;
            a.setColor(Color.RED);
            a.drawLine(50, 50, 5000, 5000);
        }
    }
}