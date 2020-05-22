import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.RenderingHints;

class Test extends JFrame {

    public Test() {
        setContentPane(new JPanel() {
                public void paintComponent(Graphics g){
                    super.paintComponent(g);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    for (int i = 0; i < 500; i++){
                        int x = (int) (Math.random() * getWidth());
                    int y = (int) (Math.random() * getHeight());
                    g.fillOval(x,y,8,8);
                    }
                }
        });
    }

    public static void main(String[] args){
        Test t = new Test();
        t.setSize(new Dimension(640, 480));
        t.setVisible(true);
    }
}