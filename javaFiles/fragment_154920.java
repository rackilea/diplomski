import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawPanelMain extends JPanel {  

   private static final int PREF_W = 600;
   private static final int PREF_H = PREF_W;
   private List<Point> POINT_LIST = Arrays.asList(new Point[] {
         new Point(160, 40),
         new Point(100, 100),
         new Point(40, 160),
         new Point(100, 220),
         new Point(160, 280),
         new Point(340, 40),
         new Point(400, 100),
         new Point(460, 160),
         new Point(400, 220),
         new Point(340, 280)
   });
   private JTabbedPane tabbedPane = new JTabbedPane();
   private int tabIndex = 0;

   public DrawPanelMain() {
      JPanel btnPanel = new JPanel();
      btnPanel.add(new JButton(new PushConfigAction("Push Config")));

      setLayout(new BorderLayout());
      add(tabbedPane, BorderLayout.CENTER);
      add(btnPanel, BorderLayout.PAGE_END);
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class PushConfigAction extends AbstractAction {
      public PushConfigAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         tabIndex++;
         String title = "Switch " + tabIndex;
         DrawPanel2 tabComponent = new DrawPanel2(POINT_LIST);
         tabbedPane.add(title, tabComponent);
      }
   }

   private static void createAndShowGui() {
      DrawPanelMain mainPanel = new DrawPanelMain();

      JFrame frame = new JFrame("DrawPanelMain");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

@SuppressWarnings("serial")
class DrawPanel2 extends JPanel {
   private static final int OVAL_WIDTH = 40;
   private static final Color INACTIVE_COLOR = Color.RED;
   private static final Color ACTIVE_COLOR = Color.green;
   private List<Point> points;
   private List<Ellipse2D> ellipses = new ArrayList<>();
   private Map<Ellipse2D, Color> ellipseColorMap = new HashMap<>();

   public DrawPanel2(List<Point> points) {
      this.points = points;
      for (Point p : points) {
         int x = p.x - OVAL_WIDTH / 2;
         int y = p.y - OVAL_WIDTH / 2;
         int w = OVAL_WIDTH;
         int h = OVAL_WIDTH;
         Ellipse2D ellipse = new Ellipse2D.Double(x, y, w, h);
         ellipses.add(ellipse);
         ellipseColorMap.put(ellipse, INACTIVE_COLOR);
      }

      MyMouseAdapter mListener = new MyMouseAdapter();
      addMouseListener(mListener);
      addMouseMotionListener(mListener);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      for (Ellipse2D ellipse : ellipses) {
         g2.setColor(ellipseColorMap.get(ellipse));
         g2.fill(ellipse);
      }
   }

   private class MyMouseAdapter extends MouseAdapter {
      @Override
      public void mousePressed(MouseEvent e) {
         for (Ellipse2D ellipse : ellipses) {
            if (ellipse.contains(e.getPoint())) {
               Color c = ellipseColorMap.get(ellipse);
               c =  (c == INACTIVE_COLOR) ? ACTIVE_COLOR : INACTIVE_COLOR;
               ellipseColorMap.put(ellipse, c);
            }
         }
         repaint();
      }
   }
}