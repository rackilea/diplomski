import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.management.StringValueExp;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AnimateNode {

    public static void main(String[] args) {
        new AnimateNode();
    }

    public AnimateNode() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new NodePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public interface Node {
        public void paint(JComponent parent, Graphics2D g2d);
        public void setColor(Color color);
        public Color getColor();
        public Node getParent();
        public Node getLeft();
        public Node getRight();
        public void setLeftNode(Node node);
        public void setRightNode(Node node);
        public Point getLocation();
        public void setLocation(Point p);
    }

    public class DefaultNode implements Node {

        private int number;
        private Node parent;
        private Node left;
        private Node right;
        private Point location;
        private Color color;

        public DefaultNode(int number, Node parent) {
            this.parent = parent;
            color = UIManager.getColor("Panel.background");
            this.number = number;
        }

        public void setLeftNode(Node left) {
            this.left = left;
        }

        public void setRightNode(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        @Override
        public Point getLocation() {
            return location;
        }

        @Override
        public void setLocation(Point location) {
            this.location = location;
        }

        @Override
        public void paint(JComponent parent, Graphics2D g2d) {

            FontMetrics fm = g2d.getFontMetrics();
            int radius = fm.getHeight();

            Point p = getLocation();

            int x = p.x - (radius / 2);
            int y = p.y - (radius / 2);

            Ellipse2D node = new Ellipse2D.Float(x, y, radius, radius);

            g2d.setColor(getColor());
            g2d.fill(node);

            g2d.setColor(Color.GRAY);
            g2d.draw(node);

            String text = String.valueOf(number);
            x = x + ((radius - fm.stringWidth(text)) / 2);
            y = y + (((radius - fm.getHeight()) / 2) + fm.getAscent());

            g2d.drawString(text, x, y);

        }

        @Override
        public void setColor(Color color) {
            this.color = color;
        }

        @Override
        public Color getColor() {
            return color;
        }

        @Override
        public String toString() {
            return number + " @ " + getLocation();
        }

    }

    public class AnimationProperties {

        private Point startPoint;
        private Point targetPoint;
        private Color startColor;
        private Color endColor;
        private Node node;

        public AnimationProperties(Node node) {
            this.node = node;
        }

        public Node getNode() {
            return node;
        }

        public void setTargetColor(Color endColor) {
            this.endColor = endColor;
        }

        public void setStartColor(Color startColor) {
            this.startColor = startColor;
        }

        public void setStartPoint(Point startPoint) {
            this.startPoint = startPoint;
        }

        public void setTargetPoint(Point targetPoint) {
            this.targetPoint = targetPoint;
        }

        public Color getTargetColor() {
            return endColor;
        }

        public Color getStartColor() {
            return startColor;
        }

        public Point getStartPoint() {
            return startPoint;
        }

        public Point getTargetPoint() {
            return targetPoint;
        }

        public Point getLocation(float progress) {
            return calculateProgress(getStartPoint(), getTargetPoint(), progress);
        }

        public Color getColor(float progress) {
            return blend(getStartColor(), getTargetColor(), 1f - progress);
        }

        public void update(float progress) {
            node.setLocation(getLocation(progress));
            node.setColor(getColor(progress));
        }

    }

    public class NodePane extends JPanel {

        private int number;
        private Node root;
        private Map<Node, AnimationProperties> aniProperties;
        private Timer animationTimer;
        private Timer startTimer;
        private long startTime;
        private int runTime = 1000;

        public NodePane() {
            aniProperties = new HashMap<>(25);

            root = addLeftNode(null);
            root.setColor(getBackground());
            addMouseListener(new MouseAdapter() {
                private Random rand;

                @Override
                public void mouseClicked(MouseEvent e) {
                    generateNextNode(root);
                    revalidate();
//                    repaint();
                }

                protected void generateNextNode(Node parent) {
                    Node child = null;
                    if (rand == null) {
                        rand = new Random(System.currentTimeMillis());
                    }
                    boolean left = rand.nextBoolean();
                    if (left) {
                        child = parent.getLeft();
                    } else {
                        child = parent.getRight();
                    }

                    if (child == null) {
                        if (left) {
                            addLeftNode(parent);
                        } else {
                            addRightNode(parent);
                        }
                    } else {
                        generateNextNode(child);
                    }
                }

            });

            startTimer = new Timer(250, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stopAnimation();
                    startTime = -1;
                    animationTimer.start();
                }

            });
            startTimer.setRepeats(false);

            animationTimer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (startTime < 0) {
                        startTime = System.currentTimeMillis();
                    }
                    float progress = 1f;
                    long duration = System.currentTimeMillis() - startTime;
                    if (duration >= runTime) {
                        ((Timer) e.getSource()).stop();
                    } else {
                        progress = (float) duration / (float) runTime;
                    }

                    for (AnimationProperties ap : aniProperties.values()) {
                        ap.update(progress);
                    }

                    repaint();

                    if (progress == 1f) {
                        aniProperties.clear();
                    }

                }

            });
            animationTimer.setRepeats(true);
            animationTimer.setCoalesce(true);
        }

        protected void stopAnimation() {
            if (animationTimer.isRunning()) {
                animationTimer.stop();
                for (AnimationProperties ap : aniProperties.values()) {
                    Node node = ap.getNode();
                    ap.setStartColor(node.getColor());
                    ap.setStartPoint(node.getLocation());
                }
            }
        }

        public Point getStartPoint(Node node) {

            Point startPoint = node.getLocation();
            while (startPoint == null) {
                node = node.getParent();
                startPoint = node.getLocation();
            }

            return startPoint;

        }

        protected void layoutNode(Node node, int x, int y) {

            if (node != null) {

                FontMetrics fm = getFontMetrics(getFont());
                int nodeHeight = fm.getHeight();

                if (node.getParent() != null) {

                    Point p = new Point(x, y);
                    Point sp = getStartPoint(node);

                    if (node.getLocation() == null) {
                        System.out.println("new node " + node);
                    }

                    if (node.getLocation() == null || !p.equals(node.getLocation())) {
                        AnimationProperties ap = new AnimationProperties(node);
                        ap.setStartColor(node.getColor());
                        ap.setTargetColor(getBackground());
                        ap.setStartPoint(sp);
                        ap.setTargetPoint(new Point(x, y));
                        node.setLocation(sp);
                        aniProperties.put(node, ap);
                        System.out.println("New Node to " + node);
                    } else {
                        aniProperties.remove(node);
                    }

                } else {

                    nodeHeight *= 2;

                }

                layoutNode(node.getLeft(), x - nodeHeight, y + nodeHeight);
                layoutNode(node.getRight(), x + nodeHeight, y + nodeHeight);

            }

        }

        @Override
        public void doLayout() {

            System.out.println("DoLayout");
            stopAnimation();

            FontMetrics fm = getFontMetrics(getFont());
            int nodeHeight = fm.getHeight();

            int x = getWidth() / 2;
            int y = nodeHeight;

            if (root != null) {

                root.setLocation(new Point(x, y));
                layoutNode(root, x, y);
//                Node node = root.getLeft();
//                while (node != null) {
//                    x -= nodeHeight;
//                    y += nodeHeight;
//                    layout(node, x, y);
//                    node = node.getLeft();
//                }
//                node = root.getRight();
//                x = getWidth() / 2;
//                y = nodeHeight;
//                while (node != null) {
//                    x += nodeHeight;
//                    y += nodeHeight;
//                    layout(node, x, y);
//                    node = node.getRight();
//                }

            }

            startTimer.restart();

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected Node createNode(Node parent) {
            DefaultNode child = new DefaultNode(++number, parent);
            child.setColor(Color.GREEN);
            System.out.println("Create new node " + child);
            return child;
        }

        protected Node addLeftNode(Node parent) {
            Node node = createNode(parent);
            if (parent != null) {
                System.out.println("Add " + node + " to left of " + parent);
                parent.setLeftNode(node);
            }
            return node;
        }

        protected Node addRightNode(Node parent) {
            Node node = createNode(parent);
            if (parent != null) {
                System.out.println("Add " + node + " to right of " + parent);
                parent.setRightNode(node);
            }
            return node;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (root != null) {

                Graphics2D g2d = (Graphics2D) g.create();

                paintConnectors(root, g2d);
                paintNode(root, g2d);

                g2d.dispose();

            }

        }

        protected void paintNode(Node node, Graphics2D g2d) {
            if (node != null && node.getLocation() != null) {
                node.paint(this, g2d);
                paintNode(node.getLeft(), g2d);
                paintNode(node.getRight(), g2d);
            }
        }

        protected void paintConnectors(Node node, Graphics2D g2d) {
            if (node != null && node.getLocation() != null) {
                Node parent = node.getParent();
                if (parent != null) {
                    g2d.setColor(Color.GRAY);
                    if (parent.getLocation() != null && node.getLocation() != null) {
                        g2d.draw(new Line2D.Float(parent.getLocation(), node.getLocation()));
                    }
                }

                paintConnectors(node.getLeft(), g2d);
                paintConnectors(node.getRight(), g2d);
            }
        }

    }

    public static Point calculateProgress(Point startPoint, Point targetPoint, double progress) {

        Point point = new Point();

        if (startPoint != null && targetPoint != null) {

            point.x = calculateProgress(startPoint.x, targetPoint.x, progress);
            point.y = calculateProgress(startPoint.y, targetPoint.y, progress);

        }

        return point;

    }

    public static int calculateProgress(int startValue, int endValue, double fraction) {

        int value = 0;
        int distance = endValue - startValue;
        value = (int) Math.round((double) distance * fraction);
        value += startValue;

        return value;

    }

    public static Color calculateProgress(Color start, Color target, double progress) {

        return blend(start, target, progress);

    }

    public static Color blend(Color color1, Color color2, double ratio) {
        float r = (float) ratio;
        float ir = (float) 1.0 - r;

        float rgb1[] = new float[3];
        float rgb2[] = new float[3];

        color1.getColorComponents(rgb1);
        color2.getColorComponents(rgb2);

        float red = rgb1[0] * r + rgb2[0] * ir;
        float green = rgb1[1] * r + rgb2[1] * ir;
        float blue = rgb1[2] * r + rgb2[2] * ir;

        if (red < 0) {
            red = 0;
        } else if (red > 255) {
            red = 255;
        }
        if (green < 0) {
            green = 0;
        } else if (green > 255) {
            green = 255;
        }
        if (blue < 0) {
            blue = 0;
        } else if (blue > 255) {
            blue = 255;
        }

        Color color = null;
        try {

            color = new Color(red, green, blue);

        } catch (IllegalArgumentException exp) {

            NumberFormat nf = NumberFormat.getNumberInstance();
            System.err.println(nf.format(red) + "; " + nf.format(green) + "; " + nf.format(blue));

        }
        return color;
    }

}