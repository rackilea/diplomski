import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager2;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CrossPanel extends JPanel implements MouseListener {

    private int orderOfCross = 0;
    private ArrayList<Cross> crosses;
    private int defaultSizeOfCrosses = 10;

    CrossPanel() {
        setOpaque(false);
        addMouseListener(this);
        crosses = new ArrayList<Cross>();
        setLayout(new PropertionalLayoutManager());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Cross cross = new Cross(orderOfCross++, defaultSizeOfCrosses);

        float xPos = (float)x / (float)getWidth();
        float yPos = (float)y / (float)getHeight();

        crosses.add(cross);

        add(cross, new PropertionalConstraints(xPos, yPos));
        revalidate();
    }

    public static String format(float value) {
        return NumberFormat.getNumberInstance().format(value);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CrossPanel crossPane = new CrossPanel();
        f.getContentPane().add(crossPane);
        f.setSize(600, 500);
        f.setLocation(200, 200);
        f.setVisible(true);
    }

    public class Cross extends JComponent {

        private int order;
        protected Cursor draggingCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        private volatile int draggedAtX, draggedAtY;
        int size;

        public Cross(int order, int size) {
            this.order = order;
            this.size = size;
//            this.setBounds(0, 0, 4 * size, 3 * size + 10);
            addDragListeners();
            setCursor(draggingCursor);
            Font f = new Font("Monospaced", Font.BOLD, size + 10);
            setFont(f);

        }

        @Override
        public Dimension getPreferredSize() {
            // This is dangrous, you are making assumptions about platforms
            // that you have no eviednce to support.
            FontMetrics fm = getFontMetrics(getFont());
            return new Dimension(Math.max(fm.stringWidth(String.valueOf(order)), size), size + fm.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.red);
            g2.setStroke(new BasicStroke(3));

            FontMetrics fm = g2.getFontMetrics();

            int width = getWidth() - 1;
            int height = getHeight() - 1;

            int x = (width - fm.stringWidth(String.valueOf(order))) / 2;
            int y = fm.getAscent();
            g2.drawString(String.valueOf(order), x, y);

            int crossSize = Math.min(width, height - fm.getHeight());
            x = (width - crossSize) / 2;
            y = fm.getHeight();
            g2.drawLine(x, y, x + crossSize, y + crossSize);
            g2.drawLine(x + crossSize, y, x, y + crossSize);
        }

        private void addDragListeners() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    draggedAtX = e.getX();
                    draggedAtY = e.getY();
                }

            });
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    Point newLocation = new Point(e.getX() - draggedAtX + getLocation().x, e.getY() - draggedAtY + getLocation().y);
                    setLocation(newLocation);
                }

            });
        }

    }

    public class PropertionalConstraints {

        private float x;
        private float y;

        public PropertionalConstraints(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        public void setX(float x) {
            if (x > 1f) {
                x = 1f;
            } else if (x < -0f) {
                x = 0f;
            }
            this.x = x;
        }

        public void setY(float y) {
            if (y > 1f) {
                y = 1f;
            } else if (y < -0f) {
                y = 0f;
            }
            this.y = y;
        }

    }

    public class PropertionalLayoutManager implements LayoutManager2 {

        private Map<Component, PropertionalConstraints> mapConstraints;

        public PropertionalLayoutManager() {
            mapConstraints = new HashMap<>(25);
        }

        public PropertionalConstraints getConstraintsFor(Component comp) {
            return mapConstraints.get(comp);
        }

        public void setConstraintsFor(Component comp, PropertionalConstraints pc) {
            mapConstraints.put(comp, pc);
        }

        @Override
        public void addLayoutComponent(Component comp, Object constraints) {
            if (constraints instanceof PropertionalConstraints) {
                mapConstraints.put(comp, (PropertionalConstraints) constraints);
            } else {
                throw new IllegalArgumentException("Constraints must be PropertionalConstraints");
            }
        }

        @Override
        public Dimension maximumLayoutSize(Container target) {
            return preferredLayoutSize(target);
        }

        @Override
        public float getLayoutAlignmentX(Container target) {
            return 0.5f;
        }

        @Override
        public float getLayoutAlignmentY(Container target) {
            return 0.5f;
        }

        @Override
        public void invalidateLayout(Container target) {

        }

        @Override
        public void addLayoutComponent(String name, Component comp) {

        }

        @Override
        public void removeLayoutComponent(Component comp) {
            mapConstraints.remove(comp);
        }

        @Override
        public Dimension preferredLayoutSize(Container parent) {
            return parent.getSize();
        }

        @Override
        public Dimension minimumLayoutSize(Container parent) {
            return preferredLayoutSize(parent);
        }

        @Override
        public void layoutContainer(Container parent) {
            int width = parent.getWidth();
            int height = parent.getHeight();
            for (Component comp : parent.getComponents()) {
                PropertionalConstraints con = mapConstraints.get(comp);
                if (con != null) {
                    int x = (int)(width * con.getX());
                    int y = (int)(height * con.getY());
                    comp.setSize(comp.getPreferredSize());
                    comp.setLocation(x, y);
                } else {
                    comp.setBounds(0, 0, 0, 0);
                }
            }
        }

    }

}