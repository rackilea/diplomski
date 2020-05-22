import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TestScrollable extends JPanel {
   private static final int REPACK_COUNT = 10;
   protected static final int RESIZE_COUNT = 5;

   public TestScrollable() {
      MyScrollable mainScrollable = new MyScrollable("Main Scrollable");
      mainScrollable.setLayout(new GridLayout(0, 1));

      int rowCount = 100;
      for (int i = 0; i < rowCount; i++) {
         JPanel rowPanel = new JPanel();
         String name = "Row Panel " + i;
         rowPanel.setName(name);
         rowPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
         rowPanel.setLayout(new BorderLayout());
         rowPanel.add(new JLabel(rowPanel.getName()));
         mainScrollable.add(rowPanel);
      }

      JViewport viewport = new JViewport() {
         @Override
         public void doLayout() {
            System.out.println("viewport doLayout called");
            super.doLayout();
         }

      };
      viewport.setView(mainScrollable);

      JScrollPane scrollPane = new JScrollPane() {
         @Override
         public void doLayout() {
            System.out.println("scrollpane doLayout called");
            super.doLayout();
         }
      };
      scrollPane.setViewport(viewport);
      setLayout(new BorderLayout());
      add(scrollPane);
   }

   private static void createAndShowGui() {
      TestScrollable mainPanel = new TestScrollable();

      final JFrame frame = new JFrame("TestScrollable") {
         @Override
         public void pack() {
            System.out.println("JFrame pack() called");
            super.pack();
         }
      };
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);

      int delay = 1000;
      // re-test pack()
      new Timer(delay, new ActionListener() {
         private int timerCount = 0;

         @Override
         public void actionPerformed(ActionEvent e) {
            System.out.println("timer count: " + timerCount);

            if (timerCount == RESIZE_COUNT) {
               int newWidth = frame.getSize().width * 2;
               int newHeight = frame.getSize().height * 2;
               Dimension newSize = new Dimension(newWidth, newHeight);
               frame.setSize(newSize);
               frame.repaint();
            }

            if (timerCount == REPACK_COUNT) {
               System.out.println("calling pack again");
               frame.pack();
               ((Timer) e.getSource()).stop();
            }
            timerCount++;
         }
      }).start();
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
class MyScrollable extends JComponent implements Scrollable {
   public static final int VP_WIDTH = 600;
   private static final int ROW_COUNT = 10;

   public MyScrollable(String name) {
      super.setName(name);
   }

   @Override
   public Dimension getPreferredScrollableViewportSize() {
      System.out.println(getName()
            + " getPreferredScrollableViewportSize called");
      Component[] comps = getComponents();
      if (comps.length > 0) {
         int height = ROW_COUNT * comps[0].getPreferredSize().height;
         return new Dimension(VP_WIDTH, height);
      }

      return super.getPreferredSize();
   }

   @Override
   public Dimension getPreferredSize() {
      System.out.println(getName() + " getPreferredSize called");
      return super.getPreferredSize();
   }

   @Override
   public int getScrollableBlockIncrement(Rectangle visibleRect,
         int orientation, int direction) {
      if (orientation == SwingConstants.HORIZONTAL) {
         return VP_WIDTH;
      }
      Component[] comps = getComponents();
      if (comps.length > 0) {
         return comps[0].getHeight() * (3 * ROW_COUNT / 4);
      }

      return getSize().height / 3;
   }

   @Override
   public boolean getScrollableTracksViewportHeight() {
      return false;
   }

   @Override
   public boolean getScrollableTracksViewportWidth() {
      return true;
   }

   @Override
   public int getScrollableUnitIncrement(Rectangle visibleRect,
         int orientation, int direction) {
      if (orientation == SwingConstants.HORIZONTAL) {
         return VP_WIDTH;
      }
      Component[] comps = getComponents();
      if (comps.length > 0) {
         return comps[0].getHeight();
      }
      return getSize().height / 3;
   }

}