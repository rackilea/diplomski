import java.awt.*;
import javax.swing.*;

public class Painting {

    public static void main(String[] args) {
        JFrame jf = new JFrame("JUST DRAW A RECTANGLE");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // null layouts cause more problems than they solve. DO NOT USE!
        //jf.setLayout(null);
        jf.setLocationRelativeTo(null);
        /* if components return a sensible preferred size, 
        it's better to add them, then pack */
        //jf.setSize(600, 600);
        //jf.setVisible(true); //  as mentioned, this should be last
        Mainting maint = new Mainting();
        jf.add(maint);
        jf.pack(); // makes the GUI the size it NEEDS to be
        jf.setVisible(true);
    }
}

class Mainting extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED); 
        g.drawRect(10, 10, 200, 200);
        System.out.println("paintComponent called");
        /* This does nothing useful, since nothing is painted
        before the Graphics instance goes out of scope! */
        //g.setColor(Color.red); 
    }

    @Override
    public Dimension getPreferredSize() {
        // Provide hints to the layout manager! 
        return new Dimension(220, 220);
    }
}