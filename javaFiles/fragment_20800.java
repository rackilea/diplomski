import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class TestA {
   private static GUI1A gui1;
   private static GUI2A gui2;

   public static void main(String[] args) {
      startGUI1();
   }

   public static void startGUI1() {
      gui1 = new GUI1A();
   }

   public static GUI1A getGUI1() {
      return gui1;
   }

   public static void startGUI2() {
      gui2 = new GUI2A();
   }

   public static GUI2A getGUI2() {
      return gui2;
   }
}

class GUI1A {
   public static final boolean CREATE_ERROR = true; 
   private JFrame frame1 = new JFrame("Frame 1");

   public GUI1A() {
      frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame1.add(new JLabel("This is Frame 1"));
      frame1.pack();
      frame1.setLocationByPlatform(true);
      frame1.setVisible(true);

      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            if (!CREATE_ERROR) {
               swapFrames();
            }
         }
      });
      if (CREATE_ERROR) {
         swapFrames();
      }
   }

   private void swapFrames() {
      TestA.startGUI2();

      System.out.println("GUI1 is null: " + (TestA.getGUI1() == null));
      System.out.println("frame1 is null: " + (frame1 == null));

      TestA.getGUI1().getFrame().dispose();
   }

   public JFrame getFrame() {
      return frame1;
   }
}

class GUI2A {
   private JFrame frame2 = new JFrame("Frame 2");

   public GUI2A() {
      frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame2.add(new JLabel("This is Frame 2"));
      frame2.pack();
      frame2.setLocationByPlatform(true);
      frame2.setVisible(true);
   }
}