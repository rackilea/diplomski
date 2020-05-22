import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestingGraphics extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        new TestingGraphics();

    }

    public TestingGraphics(){

        this.setSize(1000,1000);
        this.setPreferredSize(new Dimension(1000,1000));
        this.setTitle("Drawing tings");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new TestingPanelGraphics(), BorderLayout.CENTER);
        this.setVisible(true);

    }

    public class TestingPanelGraphics extends JPanel {

        public TestingPanelGraphics(){
            setLayout(new BorderLayout());
            this.setPreferredSize(new Dimension(1000,1000));
            this.add(new DrawStuff(), BorderLayout.CENTER);
            revalidate();
            repaint();
            this.setVisible(true); //probably not necessary

        }

        private class DrawStuff extends JComponent{

            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);

                Graphics2D graph2 = (Graphics2D) g;

                graph2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);



                Shape rootRect = new Rectangle2D.Float(100, 100, 1000, 500);

                graph2.setColor(Color.BLACK);
                graph2.draw(rootRect);
            }
        }
    }
}