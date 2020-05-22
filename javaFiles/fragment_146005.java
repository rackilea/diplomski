import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DrawShapes {

    public static void main(String[] args) {
        new DrawShapes();
    }

    public DrawShapes() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new DrawingPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class DrawingPane extends JPanel {

        private JComboBox cbShape;
        private JComboBox cbColor;
        private CanvasPane canvasPane;

        public DrawingPane() {
            setLayout(new BorderLayout());

            canvasPane = new CanvasPane();

            JPanel controls = new JPanel();
            cbShape = new JComboBox(new String[]{"Rectangle", "Circle"});
            cbColor = new JComboBox(new ColorEntry[]{
                new ColorEntry("Red", Color.RED), 
                new ColorEntry("Green", Color.GREEN), 
                new ColorEntry("Blue", Color.BLUE), 
                new ColorEntry("Magenta", Color.MAGENTA)});
            cbColor.setRenderer(new DefaultListCellRenderer() {

                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
                    if (value instanceof ColorEntry) {
                        Color color = ((ColorEntry)value).getColor();
                        setBackground(color);
                        setOpaque(true);
                    }
                    return this;
                }

            });
            JButton apply = new JButton("Apply");
            apply.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CustomShape shape = null;
                    ColorEntry entry = (ColorEntry) cbColor.getSelectedItem();
                    Color color = entry == null ? null : entry.getColor();
                    if (color != null) {
                        int width = canvasPane.getWidth() / 2;
                        int height = canvasPane.getHeight() / 2;
                        switch (cbShape.getSelectedIndex()) {
                            case 0: {
                                int x = (canvasPane.getWidth() - width) / 2;
                                int y = (canvasPane.getHeight() - height) / 2;
                                shape = new CustomRectangle(x, y, width, height, color);
                            }
                            break;
                            case 1: {
                                int diameter = Math.min(width, height);
                                int x = (canvasPane.getWidth() - diameter) / 2;
                                int y = (canvasPane.getHeight() - diameter) / 2;
                                shape = new CustomCircle(x, y, diameter, color);
                            }
                            break;
                        }
                    }
                    canvasPane.setShape(shape);
                }
            });
            controls.add(cbShape);
            controls.add(cbColor);
            controls.add(apply);

            add(canvasPane);
            add(controls, BorderLayout.SOUTH);

        }

    }

    public class ColorEntry {

        private String name;
        private Color color;

        public ColorEntry(String name, Color color) {
            this.name = name;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public Color getColor() {
            return color;
        }

        @Override
        public String toString() {
            return getName();
        }

    }

    public class CanvasPane extends JPanel {

        private CustomShape shape;

        public CanvasPane() {
        }

        public void setShape(CustomShape shape) {
            this.shape = shape;
            repaint();
        }

        public CustomShape getShape() {
            return shape;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (shape != null) {
                Graphics2D g2d = (Graphics2D) g;
                shape.paint(g2d);
            }
        }

    }

    public interface CustomShape {

        public Rectangle getBounds();

        public Color getColor();

        public void paint(Graphics2D g2d);

    }

    public abstract class AbstractCustomShape implements CustomShape {

        private Rectangle bounds;
        private Color color;

        @Override
        public Rectangle getBounds() {
            return bounds;
        }

        @Override
        public Color getColor() {
            return color;
        }

        public void setBounds(Rectangle bounds) {
            this.bounds = bounds;
        }

        public void setColor(Color color) {
            this.color = color;
        }

    }

    public class CustomRectangle extends AbstractCustomShape {

        public CustomRectangle(int x, int y, int width, int height, Color color) {
            setBounds(new Rectangle(x, y, width, height));
            setColor(color);
        }

        @Override
        public void paint(Graphics2D g2d) {
            g2d.setColor(getColor());
            g2d.fill(getBounds());
        }

    }

    public class CustomCircle extends AbstractCustomShape {

        public CustomCircle(int x, int y, int diameter, Color color) {
            setBounds(new Rectangle(x, y, diameter, diameter));
            setColor(color);
        }

        @Override
        public void paint(Graphics2D g2d) {
            g2d.setColor(getColor());
            Rectangle bounds = getBounds();
            Ellipse2D circle = new Ellipse2D.Double(bounds.x, bounds.y, bounds.width, bounds.height);
            g2d.fill(circle);
        }

    }

}