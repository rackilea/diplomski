import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {

    public static List<Circle> circleList = new ArrayList<>();
    private static Random random = new Random();

    public Main() {
        for (int i = 0; i < 2; i++) {
            // width and height are specified here instead of inside the Circle.drawCircle method.
            circleList.add(new Circle(random.nextInt(500), random.nextInt(500), 200, 200));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Circle CircleShape : circleList) {
            CircleShape.collision();
            CircleShape.drawCircle(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new Main());
    }

}