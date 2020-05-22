import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;

public class STTestSimple {
   private static void createAndShowUI() {
      STDrawPanel drawPanel = new STDrawPanel();
      STMouseAdapter mAdapter = new STMouseAdapter(drawPanel);
      drawPanel.addMouseListener(mAdapter);
      drawPanel.addMouseMotionListener(mAdapter);

      JFrame frame = new JFrame("Drawing");
      frame.getContentPane().add(drawPanel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            createAndShowUI();
         }
      });
   }
}

@SuppressWarnings("serial")
class STDrawPanel extends JPanel {
   private static final int ST_WIDTH = 700;
   private static final int ST_HEIGHT = 500;
   private static final Color BACKGROUND_COLOR = Color.white;
   private static final float STROKE_WIDTH = 6f;
   private static final Stroke STROKE = new BasicStroke(STROKE_WIDTH,
            BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
   private static final Color[] colors = {Color.black, Color.blue, Color.red,
      Color.green, Color.orange, Color.MAGENTA};

   private BufferedImage bImage = new BufferedImage(ST_WIDTH, ST_HEIGHT,
            BufferedImage.TYPE_INT_RGB);
   private Color color = Color.black;
   private ArrayList<Point> points = new ArrayList<Point>();
   private int colorIndex = 0;

   public STDrawPanel() {
      Graphics g = bImage.getGraphics();
      g.setColor(BACKGROUND_COLOR);
      g.fillRect(0, 0, ST_WIDTH, ST_HEIGHT);
      g.dispose();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(bImage, 0, 0, null);
      Graphics2D g2 = (Graphics2D) g;
      drawCurve(g2);
   }

   private void addCurveToBufferedImage() {
      Graphics2D g2 = bImage.createGraphics();
      drawCurve(g2);
      g2.dispose();
   }

   private void drawCurve(Graphics2D g2) {
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
               RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setStroke(STROKE);
      g2.setColor(color);
      if (points != null && points.size() > 1) {
         for (int i = 0; i < points.size() - 1; i++) {
            int x1 = points.get(i).x;
            int y1 = points.get(i).y;
            int x2 = points.get(i + 1).x;
            int y2 = points.get(i + 1).y;
            g2.drawLine(x1, y1, x2, y2);
         }
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(ST_WIDTH, ST_HEIGHT);
   }

   public void curveStart(Point point) {
      points.clear();
      points.add(point);
   }

   public void curveEnd(Point point) {
      points.add(point);
      addCurveToBufferedImage();
      points.clear();
      repaint();

      colorIndex++;
      colorIndex %= colors.length;
      setColor(colors[colorIndex]);
   }

   public void curveAdd(Point point) {
      points.add(point);
      repaint();
   }

   public void setColor(Color color) {
      this.color = color;
   }
}

class STMouseAdapter extends MouseAdapter {
   private STDrawPanel drawPanel;

   public STMouseAdapter(STDrawPanel drawPanel) {
      this.drawPanel = drawPanel;
   }

   @Override
   public void mousePressed(MouseEvent e) {
      drawPanel.curveStart(e.getPoint());
   }

   @Override
   public void mouseReleased(MouseEvent e) {
      drawPanel.curveEnd(e.getPoint());
   }

   @Override
   public void mouseDragged(MouseEvent e) {
      drawPanel.curveAdd(e.getPoint());
   }
}