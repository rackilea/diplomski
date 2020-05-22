import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test {

    private static final String FILE = "Desktop/Assign2Test1.txt";
    private static Point[] points;

    public static void main(final String[] args){
        try{
            final BufferedReader br = new BufferedReader(new FileReader(new File(FILE)));
            points = new Point[Integer.parseInt(br.readLine())];
            int i = 0;
            int xMax = 0;
            int yMax = 0;
            while(br.ready()){
                final String[] split = br.readLine().split("\u0009");
                final int x = Integer.parseInt(split[0]);
                final int y = Integer.parseInt(split[1]);
                xMax = Math.max(x, xMax);
                yMax = Math.max(y, yMax);
                points[i++] = new Point(x, y);
            }
            final JFrame frame = new JFrame("Point Data Rendering");
            final Panel panel = new Panel();
            panel.setPreferredSize(new Dimension(xMax + 10, yMax + 10));
            frame.setContentPane(panel);
            frame.pack();
            frame.setVisible(true);
            frame.repaint();
        } catch (final Exception e){
            e.printStackTrace();
        }
    }

    public static class Panel extends JPanel {

        @Override
        public void paintComponent(final Graphics g){
            g.setColor(Color.RED);
            for(final Point p : points){
                g.fillRect((int) p.getX(), (int) p.getY(), 2, 2);
            }
        }

    }

}