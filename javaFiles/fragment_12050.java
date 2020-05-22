import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.Graphics.*;
import java.awt.event.*;
import java.text.*;
import java.util.Random;

public class Pythag {

    public Pythag() {

        JFrame frame = new JFrame("JFrame");

        frame.setContentPane(new MyPanel());

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Pythag();
            }
        });

    }

    public class MyPanel extends JPanel {

        int x;
        int y;

        public MyPanel() {

            ActionListener al = new ActionListener() {
                Random r = new Random();

                @Override
                public void actionPerformed(ActionEvent e) {

                    x = r.nextInt(getWidth()); // Random x-coordinate
                    y = r.nextInt(getHeight()); // Random y-coordinate
                    repaint(); // Repaints the panel

                }
            };

            Timer timer = new Timer(500, al); // Runs ever 500 milliseconds.
            timer.start();

        }

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g); // Removes previous drawings

            g.setColor(Color.RED);
            g.fillRect(x, y, 10, 10);

        }

    }

}