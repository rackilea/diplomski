import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class MyMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        MyPainting mainPanel = new MyPainting();
        MenuCreator menuCreator = new MenuCreator(mainPanel);

        JFrame frame = new JFrame("MyPainting");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.setJMenuBar(menuCreator.getMenubar());
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}

@SuppressWarnings("serial")
class MyPainting extends JPanel {
    private static final int IMG_W = 600;
    private static final int IMG_H = 450;
    private static final int STROKE_W = 3;
    private static final Stroke STROKE = new BasicStroke(STROKE_W);
    private BufferedImage img = new BufferedImage(IMG_W, IMG_H, BufferedImage.TYPE_INT_ARGB);
    private Color drawColor = Color.BLACK;

    public MyPainting() {
        setPreferredSize(new Dimension(IMG_W, IMG_H));
        MyMouse myMouse = new MyMouse();
        addMouseListener(myMouse);
        addMouseMotionListener(myMouse);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }

    private class MyMouse extends MouseAdapter {
        private Graphics2D g2 = null;
        private Point p0;

        @Override
        public void mousePressed(MouseEvent e) {
            if (img == null) {
                return;
            }
            g2 = img.createGraphics();
            g2.setStroke(STROKE);
            g2.setColor(drawColor);
            p0 = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (p0 == null) {
                return;
            }
            drawLine(e);

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (p0 == null) {
                return;
            }
            drawLine(e);
            g2.dispose();
            p0 = null;
        }

        private void drawLine(MouseEvent e) {
            Point p1 = e.getPoint();
            g2.drawLine(p0.x, p0.y, p1.x, p1.y);
            repaint();
            p0 = p1;
        }

    }

    public void setDrawColor(Color drawColor) {
        this.drawColor = drawColor;
    }

    public void clear() {
        img = new BufferedImage(IMG_W, IMG_H, BufferedImage.TYPE_INT_ARGB);
        repaint();
    }
}

class MenuCreator {
    private JMenuBar menubar = new JMenuBar();
    private MyPainting myPainting;

    public MenuCreator(MyPainting myPainting) {
        JMenuItem clearDrawing = new JMenuItem(new AbstractAction("Clear Drawing") {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (myPainting != null) {
                    myPainting.clear();
                }
            }
        });
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(clearDrawing);

        JMenu colourMenu = new JMenu("Colour");
        for (MyColor myColor : MyColor.values()) {
            colourMenu.add(new JMenuItem(new ColorAction(myColor)));
        }

        menubar.add(fileMenu);
        menubar.add(new JMenu("Pen"));
        menubar.add(colourMenu);
        this.myPainting = myPainting;
    }

    public JMenuBar getMenubar() {
        return menubar;
    }

    private class ColorAction extends AbstractAction {
        private MyColor myColor;

        public ColorAction(MyColor myColor) {
            super(myColor.getText());
            this.myColor = myColor;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (myPainting != null) {
                myPainting.setDrawColor(myColor.getColor());
            }
        }
    }
}

enum MyColor {
    BLACK("Black", Color.BLACK), RED("Red", Color.RED), ORANGE("Orange", Color.ORANGE), BLUE("Blue", Color.BLUE);

    private String text;
    private Color color;
    private MyColor(String text, Color color) {
        this.text = text;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public Color getColor() {
        return color;
    }

}