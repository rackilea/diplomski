import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;



public class TempProject extends JPanel{
    /** Stores info about circles  */
    public ArrayList<CircleInfo> circles = new ArrayList<CircleInfo>();

    /** fields that were in example code */
    public int count = 0;
    public final int radius = 20;
    public final int clients = 20;

    public TempProject(){

        addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent evt) {
                count += 1;
                if (count <= clients) {
                        // Store info about the circle to draw
                    circles.add(new CircleInfo(evt.getX() - (radius / 2), evt.getY() - (radius / 2), radius));
                        // Tell swing to repaint asap
                    repaint();
                }
            }});
    }

    @Override
    public void paintComponent(Graphics g ) {
            super.paintComponent(g);

            //Iterates through saved circles and paints them
        for(CircleInfo circle : circles){
            g.drawOval(circle.x - circle.radius, circle.y - circle.radius, 2 * circle.radius, 2 * circle.radius);
            g.setColor(Color.BLACK);
            g.fillOval(circle.x - circle.radius, circle.y - circle.radius, 2 * circle.radius, 2 * circle.radius);
        }
    }

    public static void main(String args[])    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                frame.setContentPane(new TempProject());  
                frame.setPreferredSize(new Dimension(400, 300));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    /** Simple class for storing Circle info */
    public static class CircleInfo{
        int x = 0;
        int y = 0;
        int radius = 0;

        public CircleInfo(int x, int y, int radius){
            this.x = x; this.y = y; this.radius = radius;
        }
    }

}