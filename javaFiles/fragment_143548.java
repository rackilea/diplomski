import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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

        private JButton[] buttons = new JButton[]{
            new JButton("1"),
            new JButton("2"),
            new JButton("3"),
            new JButton("4"),};

        private List<Connection> connections;

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(10, 10, 10, 10);
            add(buttons[0], gbc);

            gbc.gridx = 2;
            gbc.gridy = 0;
            add(buttons[1], gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            add(buttons[2], gbc);

            gbc.gridx = 2;
            gbc.gridy = 2;
            add(buttons[3], gbc);

            connections = new ArrayList<Connection>(25);
            connections.add(new Connection(buttons[0], buttons[1]));
            connections.add(new Connection(buttons[0], buttons[2]));
            connections.add(new Connection(buttons[0], buttons[3]));

            connections.add(new Connection(buttons[1], buttons[3]));
            connections.add(new Connection(buttons[2], buttons[3]));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            for (Connection connection : connections) {
                JButton source = connection.getSource();
                JButton dest = connection.getDestination();

                if (source.getX() == dest.getX()) {
                    // Same column...
                    g2d.drawLine(source.getX() + source.getWidth() / 2, source.getY(),
                                    dest.getX() + source.getWidth() / 2, dest.getY());
                } else if (source.getY() == dest.getY()) {
                    // Same row...
                    g2d.drawLine(source.getX(), source.getY() + source.getHeight() / 2,
                                    dest.getX(), dest.getY() + dest.getHeight() / 2);
                } else {

                    Path2D path = new Path2D.Double();
                    path.moveTo(horizontalCenter(source), verticalCenter(source));
                    path.curveTo(horizontalCenter(source), verticalCenter(dest), 
                                    horizontalCenter(source), verticalCenter(dest), 
                                    horizontalCenter(dest), verticalCenter(dest));
                    g2d.draw(path);

                }
            }
            g2d.dispose();
        }

        protected double horizontalCenter(JComponent bounds) {

            return bounds.getX() + bounds.getWidth() / 2d;

        }

        protected double verticalCenter(JComponent bounds) {

            return bounds.getY() + bounds.getHeight() / 2d;

        }

        protected boolean hasIntersection(Line2D line, JComponent... exclude) {
            List<JComponent> toExclude = Arrays.asList(exclude);
            boolean intersects = false;
            for (Component comp : getComponents()) {
                if (!toExclude.contains(comp)) {
                    if (line.intersects(comp.getBounds())) {
                        System.out.println(line.getP1() + "-" + line.getP2() + " intersets with " + ((JButton)comp).getText() + "; " + comp.getBounds());
                        intersects = true;
                        break;
                    }
                }
            }
            return intersects;
        }

        protected Line2D lineDownTo(JComponent from, JComponent to) {
            return new Line2D.Double(horizontalCenter(from), from.getY(), horizontalCenter(from), verticalCenter(to));      
        }

        protected Line2D lineAcrossTo(JComponent from, JComponent to) {
            return new Line2D.Double(from.getX(), verticalCenter(from), horizontalCenter(to), verticalCenter(from));        
        }

        protected Point2D centerOf(Rectangle bounds) {
            return new Point2D.Double(bounds.getX() + bounds.getWidth() / 2, bounds.getY() + bounds.getHeight() / 2);
        }

        protected boolean canGoDownTo(Point2D startPoint, Point2D endPoint, JComponent to, JComponent from) {
            Point2D targetPoint = new Point2D.Double(startPoint.getX(), endPoint.getY());
            return !hasIntersection(new Line2D.Double(startPoint, targetPoint), to, from);
        }

        public class Connection {

            private final JButton source;
            private final JButton destination;

            public Connection(JButton source, JButton destination) {
                this.source = source;
                this.destination = destination;
            }

            public JButton getSource() {
                return source;
            }

            public JButton getDestination() {
                return destination;
            }

        }

    }

}