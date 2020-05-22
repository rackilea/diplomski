import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DrawLines {

    public static void main(String[] args) {
        new DrawLines();
    }

    public DrawLines() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Line2D currentLine;
        private Map<Shape, Color> mapColors;

        private Color currentColor;

        private List<Shape> shapes;

        public TestPane() {

            mapColors = new HashMap<>(25);
            shapes = new ArrayList<>(25);

            InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap actionMap = getActionMap();

            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F, 0), "foreground");
            inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_B, 0), "background");

            actionMap.put("foreground", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentColor = Color.GREEN;
                    if (currentLine != null) {
                        mapColors.put(currentLine, currentColor);
                        repaint();
                    }
                }
            });
            actionMap.put("background", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentColor = Color.RED;
                    if (currentLine != null) {
                        mapColors.put(currentLine, currentColor);
                        repaint();
                    }
                }
            });

            MouseAdapter ma = new MouseAdapter() {

                private Point p1, p2;

                @Override
                public void mousePressed(MouseEvent e) {
                    p1 = e.getPoint();
                    currentLine = null;
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    p2 = e.getPoint();
                    if (currentLine == null) {
                        currentLine = createLine(p1.x, p1.y, e.getX(), e.getY());
                    } else {
                        currentLine.setLine(p1, p2);
                    }

                    mapColors.put(currentLine, currentColor);
                    shapes.add(currentLine);
                    repaint();                  
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    p2 = e.getPoint();
                    if (currentLine == null) {
                        currentLine = createLine(p1.x, p1.y, e.getX(), e.getY());
                    } else {
                        currentLine.setLine(p1, p2);
                    }

                    repaint();
                }

                private Line2D.Float createLine(int x1, int y1, int x2, int y2) {
                    return new Line2D.Float(x1, y1, x2, y2);
                }
            };

            addMouseListener(ma);
            addMouseMotionListener(ma);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            for (Shape shape : shapes) {
                Color color = mapColors.get(shape);
                if (color == null) {
                    color = Color.BLACK;
                }
                g2d.setColor(color);
                g2d.draw(shape);
            }

            if (currentLine != null) {
                Color color = mapColors.get(currentLine);
                if (color == null) {
                    color = currentColor;
                }
                g2d.setColor(color);
                g2d.draw(currentLine);
            }
            g2d.dispose();
        }

    }

}