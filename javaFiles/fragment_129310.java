import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private List<Rectangle> boxes;
        private Map<Rectangle, Point> vectors;

        public TestPane() {
            boxes = new ArrayList<>(25);
            vectors = new HashMap<>(25);
            Random random = new Random();
            for (int index = 0; index < 10; index++) {
                int x = random.nextInt(400 - 10);
                int y = random.nextInt(400 - 10);

                Rectangle box = new Rectangle(x, y, 10, 10);
                boxes.add(box);

                int xDelta = random.nextBoolean() ? 1 : -1;
                int yDelta = random.nextBoolean() ? 1 : -1;

                vectors.put(box, new Point(xDelta, yDelta));
            }

            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (Rectangle box : boxes) {
                        Point delta = vectors.get(box);

                        if (delta == null) {
                            int xDelta = random.nextBoolean() ? 1 : -1;
                            int yDelta = random.nextBoolean() ? 1 : -1;
                            delta = new Point(xDelta, yDelta);
                        }

                        int x = box.x + delta.x;
                        int y = box.y + delta.y;

                        if (x < 0) {
                            x = 0;
                            delta.x *= -1;
                        } else if (x + box.width > getWidth()) {
                            x = getWidth() - box.width;
                            delta.x *= -1;
                        }
                        if (y < 0) {
                            y = 0;
                            delta.y *= -1;
                        } else if (y + box.height > getHeight()) {
                            y = getHeight() - box.height;
                            delta.y *= -1;
                        }

                        box.setLocation(x, y);
                        vectors.put(box, delta);
                    }
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 200);
        }

        protected Shape getTextShape() {
            Graphics2D g2d = (Graphics2D) getGraphics();
            if (g2d == null) {
                return null;
            }
            Font font = new Font("Arial", Font.BOLD, 48);
            g2d.setFont(font);

            FontRenderContext frc = g2d.getFontRenderContext();
            GlyphVector gv = font.createGlyphVector(frc, "Cats with hats");
            Rectangle2D box = gv.getVisualBounds();

            // Calclate the location of the text and offset the glyph shape...
            float x = (float) (getWidth() - box.getWidth()) / 2f;
            float y = (float) (((getHeight() - box.getHeight()) / 2f) + (-box.getY()));

            return gv.getOutline(x, y);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            Shape shape = getTextShape();

            g2d.setColor(Color.BLACK);
            g2d.fill(shape);
            g2d.setColor(Color.RED);
            g2d.draw(shape);

            for (Rectangle box : boxes) {
                g2d.setColor(Color.BLACK);
                if (shape.intersects(box)) {
                    g2d.setColor(Color.RED);
                }
                g2d.draw(box);
            }
        }

    }

}