import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class TwoButtonsTest {

    JFrame frame;
    Timer timer;
    boolean isClicked;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TwoButtonsTest test = new TwoButtonsTest();
                test.go();
            }
        });
    }
    final DrawPanel myDraw = new DrawPanel();

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new StartListener());
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new StopListener());


        frame.add(myDraw, BorderLayout.CENTER);
        frame.add(startButton, BorderLayout.NORTH);
        frame.add(stopButton, BorderLayout.SOUTH);


        frame.pack();
        frame.setVisible(true);

        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                myDraw.repaint();
            }
        });
    }

    class StartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //needs to be implemented
            if (!isClicked) {
            }

            myDraw.clearRects();

            isClicked = true;
            timer.start();
        }
    }

    class StopListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //needs to be implemented
            timer.stop();
            isClicked = false;
        }
    }

    class DrawPanel extends JPanel {

        private ArrayList<MyRectangle> rects = new ArrayList<>();
        private Random rand = new Random();

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            addRect();
            for (MyRectangle r : rects) {
                g.setColor(r.getColor());
                g.fillRect(r.x, r.y, r.width, r.height);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }

        public void clearRects() {
            rects.clear();
        }

        public void addRect() {
            // following 4 lines make sure the rect stays within the frame
            int ht = rand.nextInt(getHeight());
            int wd = rand.nextInt(getWidth());

            int x = rand.nextInt(getWidth() - wd);
            int y = rand.nextInt(getHeight() - ht);

            int red = (int) (Math.random() * 256);
            int blue = (int) (Math.random() * 256);
            int green = (int) (Math.random() * 256);

            rects.add(new MyRectangle(x, y, wd, ht, new Color(red, blue, green)));
        }
    } // close inner class
}

class MyRectangle extends Rectangle {

    Color color;

    public MyRectangle(int x, int y, int w, int h, Color c) {
        super(x, y, w, h);
        this.color = c;
    }

    public Color getColor() {
        return color;
    }
}