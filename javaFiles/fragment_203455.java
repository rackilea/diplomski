import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.swing.*;

@SuppressWarnings("serial")
public class Panel2 extends JPanel {
    // preferred size constants
    private static final int PREF_W = 600;
    private static final int PREF_H = PREF_W;

    // map to hold circles and colors
    private Map<Shape, Color> shapeColorMap = new LinkedHashMap<>();

    public Panel2() {
        add(new JButton(new RandomColorAction()));
        MyMouse myMouse = new MyMouse();
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        // create *smooth* drawings
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        paintStuff(g2);
    }

    private void paintStuff(Graphics2D g2) {
        // iterate through our map extracting all circles and colors
        // and drawing them
        for (Entry<Shape, Color> entry : shapeColorMap.entrySet()) {
            Shape shape = entry.getKey();
            Color color = entry.getValue();
            g2.setColor(color);
            g2.fill(shape);
        }
    }

    private class MyMouse extends MouseAdapter {
        private Entry<Shape, Color> selected = null;
        private Path2D path;
        private Point p = null;

        @Override
        public void mousePressed(MouseEvent e) {
            Set<Entry<Shape, Color>> entrySet = shapeColorMap.entrySet();
            // get Shape pressed
            for (Entry<Shape, Color> entry : entrySet) {
                if (entry.getKey().contains(e.getPoint())) {
                    selected = entry;
                }
            }

            if (selected != null) {
                path = new Path2D.Double(selected.getKey());
                // move it to the top
                entrySet.remove(selected);
                shapeColorMap.put(path, selected.getValue());

                p = e.getPoint();
                repaint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (selected != null) {
                moveSelected(e);
            }
            selected = null;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (selected != null) {
                moveSelected(e);
            }
        }

        private void moveSelected(MouseEvent e) {
            int x = e.getX() - p.x;
            int y = e.getY() - p.y;
            p = e.getPoint();

            AffineTransform at = AffineTransform.getTranslateInstance(x, y);
            path.transform(at);
            repaint();
        }
    }

    // listener for our button
    private class RandomColorAction extends AbstractAction {
        private static final int CIRC_WIDTH = 100;
        private Random random = new Random();
        private int count = 0;

        public RandomColorAction() {
            super("Random Circle: 0");
            putValue(MNEMONIC_KEY, KeyEvent.VK_R);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // create our random ellipses
            int x = random.nextInt(getWidth() - CIRC_WIDTH);
            int y = random.nextInt(getHeight() - CIRC_WIDTH);
            Shape shape = new Ellipse2D.Double(x, y, CIRC_WIDTH, CIRC_WIDTH);

            // create our random color using HSB for brighter colors
            float hue = random.nextFloat();
            float saturation = (float) (0.8 + random.nextFloat() * 0.2);
            float brightness = (float) (0.8 + random.nextFloat() * 0.2);
            Color color = Color.getHSBColor(hue, saturation, brightness);
            shapeColorMap.put(shape, color);

            // increment count, place items into map, repaint
            count++;
            putValue(NAME, "Random Circle: " + count);
            repaint();
        }
    }

    private static void createAndShowGui() {
        Panel2 mainPanel = new Panel2();

        JFrame frame = new JFrame("Panel2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}