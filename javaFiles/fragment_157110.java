import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class ImageRectMain extends JPanel {
   private ImageRect imgRect;
   private DefaultListModel listDataModel = new DefaultListModel();
   private JList list = new JList(listDataModel);
   private Map<String, Point> stringPointMap = new HashMap<String, Point>();

   public ImageRectMain() {
      String nose = "Nose";
      String ear = "Ear";
      String rightEye = "Right Eye";
      String leftEye = "Left Eye";
      listDataModel.addElement(ear);
      listDataModel.addElement(nose);
      listDataModel.addElement(rightEye);
      listDataModel.addElement(leftEye);
      stringPointMap.put(nose, new Point(480, 500));
      stringPointMap.put(ear, new Point(270, 230));
      stringPointMap.put(rightEye, new Point(380, 390));
      stringPointMap.put(leftEye, new Point(662, 440));

      MouseAdapter listMouseAdapter = new MouseAdapter() {
         @Override
         public void mouseMoved(MouseEvent e) {
            listMouseMoved(e);
         }

         @Override
         public void mouseExited(MouseEvent e) {
            listMouseExited(e);
         }

      };
      list.addMouseMotionListener(listMouseAdapter);
      list.addMouseListener(listMouseAdapter);

      try {
         imgRect = new ImageRect();

         // !! added
         imgRect.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
               imgMousePressed(e);
            }
         }); 

         JPanel eastPanel = new JPanel();
         eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.PAGE_AXIS));
         eastPanel.add(new JLabel("You have tagged the following:"));
         eastPanel.add(new JScrollPane(list));
         eastPanel.add(Box.createVerticalGlue());
         eastPanel.add(Box.createVerticalGlue());
         eastPanel.add(Box.createVerticalGlue());
         eastPanel.add(Box.createVerticalGlue());
         setLayout(new BorderLayout());
         add(imgRect, BorderLayout.CENTER);
         add(eastPanel, BorderLayout.EAST);
      } catch (MalformedURLException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   // !! added
   private void imgMousePressed(MouseEvent e) {
      String result = JOptionPane.showInputDialog(this,
            "Please enter name for this point on image:");
      if (result != null) {
         stringPointMap.put(result, e.getPoint());
         listDataModel.addElement(result);
      }
   }

   private void listMouseExited(MouseEvent e) {
      imgRect.setDisplayPoint(null);
   }

   private void listMouseMoved(MouseEvent e) {
      int index = list.locationToIndex(e.getPoint());
      Object value = listDataModel.get(index);
      if (value != null) {
         Point point = stringPointMap.get(value.toString());
         if (point != null) {
            imgRect.setDisplayPoint(point);
         }
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("ImageRectMain");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new ImageRectMain());
      frame.pack();
      frame.setLocationRelativeTo(null);
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
class ImageRect extends JPanel {
   public static final String IMAGE_PATH = "http://i.stack.imgur.com/7oNzg.jpg";
   private static final int DEFAULT_W = 687;
   private static final int DEFAULT_H = 636;
   private static final int X_SHIFT = -6;
   private static final int Y_SHIFT = -26;
   private static final Color RECT_COLOR = Color.pink;
   private static final int RECT_WIDTH = 40;
   private BufferedImage img;
   private Point displayPoint = null;

   public ImageRect() throws MalformedURLException, IOException {
      img = ImageIO.read(new URL(IMAGE_PATH));
   }

   public void setDisplayPoint(Point p) {
      this.displayPoint = p;
      repaint();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (img != null) {
         g.drawImage(img, X_SHIFT, Y_SHIFT, null);
      }
      if (displayPoint != null) {
         g.setColor(RECT_COLOR);
         int x = displayPoint.x - RECT_WIDTH / 2;
         int y = displayPoint.y - RECT_WIDTH / 2;
         int width = RECT_WIDTH;
         int height = RECT_WIDTH;
         g.drawRect(x, y, width, height);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(DEFAULT_W, DEFAULT_H);
   }
}