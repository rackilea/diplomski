import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class MAP extends JFrame {

    public static void main(String[] args) throws IOException {
        MAP map = new MAP();
    }

    public static class ColoredShape {
        private Shape shape;
        private Color color;

        public ColoredShape(Shape shape, Color color) {
            super();
            this.shape = shape;
            this.color = color;
        }

        public Shape getShape() {
            return shape;
        }

        public Color getColor() {
            return color;
        }
    }

    int x = -32;
    int y = 0;
    List<ColoredShape> shapes = new ArrayList<ColoredShape>();
    Graphics2D g2;

    private class PaintSurface extends JComponent {

        public PaintSurface() {
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g2 = (Graphics2D) g;
            for (ColoredShape s : shapes) {
                g2.setColor(s.getColor());
                g2.draw(s.getShape());
            }

        }
    }

    public MAP() throws FileNotFoundException, IOException {
        JFrame frame = new JFrame();
        frame.setTitle("Grid Maker");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(new PaintSurface(), BorderLayout.CENTER);
        frame.setVisible(true);

        readNextLine();
    }

    private void readNextLine() throws IOException {
        BufferedReader in = new BufferedReader(new StringReader("11121\n1221\n2212\n221121\n111221\n11221\n222\n2222\n"));
        String line = in.readLine();

        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                Color color = null;
                if (c == '1') {
                    color = Color.RED;
                } else if (c == '2') {
                    color = Color.GREEN;
                }
                if (color != null) {
                    shapes.add(new ColoredShape(new Rectangle2D.Float(x, y, 32, 32), color));
                    x += 32;
                    repaint();
                }
            }

            line = in.readLine();
            x = -32;
            y += 32;
        }
    }
}