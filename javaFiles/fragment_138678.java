import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DrawShapes extends JFrame {
    public ArrayList<Shape> shapeList = new ArrayList<Shape>();

    public DrawShapes(String title) {
        super(title);

        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 700);
        this.setLocationRelativeTo(null);

        this.initComponents();
    }

    private void initComponents() {
        shapeList.add(new RectangleShape(20, 20, 60, 60));
        shapeList.add(new RectangleShape(130, 30, 80, 11));
        shapeList.add(new RectangleShape(200, 30, 20, 140));
    }

    @Override
    public void paint(Graphics g) {
        for (Shape s : shapeList) {
            s.draw(g);
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DrawShapes d = new DrawShapes("Drawing program");
                d.setVisible(true);
            }
        });
    }
}