import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI extends JFrame implements ActionListener {

    private boolean drawLine = false;
    private boolean drawRec = false;
    private boolean drawOval = false;
    private final JButton line;
    private final JButton oval;
    private final JButton rectangle;
    private final JPanel buttonPanel;
    public DrawStuff drawPanel = new DrawStuff();
    public int x1;
    public int x2;
    public int y1;
    public int y2;
    public int click;

    public GUI() {
        super("Graphics IO");
        this.click = 1;
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));

        line = new JButton("Line");
        line.addActionListener(this);
        buttonPanel.add(line);

        oval = new JButton("Oval");
        oval.addActionListener(this);
        buttonPanel.add(oval);

        rectangle = new JButton("Rectangle");
        rectangle.addActionListener(this);
        buttonPanel.add(rectangle);

        Container contentPane = this.getContentPane();
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        add(drawPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == line) {
            drawPanel.setDrawShape(DrawStuff.DrawShape.LINE);
        } else if (source == oval) {
            drawPanel.setDrawShape(DrawStuff.DrawShape.OVAL);
        } else if (source == rectangle) {
            drawPanel.setDrawShape(DrawStuff.DrawShape.RECTANGLE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                GUI guiIO = new GUI();
            }
        });
    }

    public static class DrawStuff extends JPanel {

        public enum DrawShape {

            LINE, OVAL, RECTANGLE;
        }

        private ArrayList<Shape> shapes = new ArrayList<>();
        private DrawShape drawShape = DrawShape.LINE;
        private Shape currentShape;

        public DrawStuff() {
            setBackground(Color.BLUE);

            MouseAdapter ma = new MouseAdapter() {
                private Point clickPoint;

                @Override
                public void mousePressed(MouseEvent e) {
                    clickPoint = e.getPoint();
                    currentShape = null;
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (currentShape != null) {
                        shapes.add(currentShape);
                        currentShape = null;
                        repaint();
                    }
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    Point p = e.getPoint();
                    switch (getDrawShape()) {
                        case LINE:
                            currentShape = new Line2D.Double(clickPoint, e.getPoint());
                            break;
                        case OVAL:
                        case RECTANGLE:
                            int x = clickPoint.x;
                            int y = clickPoint.y;
                            int width = p.x - clickPoint.x;
                            int height = p.y - clickPoint.y;

                            if (width < 0) {
                                x = p.x;
                                width *= -1;
                            }
                            if (height < 0) {
                                y = p.y;
                                height *= -1;
                            }
                            switch (getDrawShape()) {
                                case OVAL:
                                    currentShape = new Ellipse2D.Double(x, y, width, height);
                                    break;
                                case RECTANGLE:
                                    currentShape = new Rectangle2D.Double(x, y, width, height);
                                    break;
                            }
                            break;
                    }

                    repaint();
                }

            };

            addMouseListener(ma);
            addMouseMotionListener(ma);
        }

        public DrawShape getDrawShape() {
            return drawShape;
        }

        public void setDrawShape(DrawShape drawShape) {
            this.drawShape = drawShape;
            currentShape = null;
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.BLACK);

            for (Shape shape : shapes) {
                g2d.draw(shape);
            }

            if (currentShape != null) {

                g2d.setColor(Color.RED);
                g2d.draw(currentShape);

            }

        }
    }

}