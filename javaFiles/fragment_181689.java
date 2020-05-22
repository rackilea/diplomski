import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppletEg extends JApplet {
   private static final int MAX_LOOP = 30;
   private static final long SLEEP_TIME = 500;
   private JDialog console;
   private JTextArea consoleText;
   private Thread gameThread;

   @Override
   public void init() {
      Window win = SwingUtilities.getWindowAncestor(this);
      console = new JDialog(win);
      consoleText = new JTextArea();
      consoleText.setPreferredSize(new Dimension(500, 300));

      console.add(new JScrollPane(consoleText));
      console.pack();
      console.setLocationByPlatform(true);
      console.setVisible(true);

      gameThread = new Thread() {
         public void run() {
            mainLoop();
         }
      };
      gameThread.start();
   }

   private void mainLoop() {
      for (int i = 0; i < MAX_LOOP; i++) {
         System.out.println("i: " + i);
         try {
            Thread.sleep(SLEEP_TIME);
         } catch (InterruptedException e) {
         }
      }
   }
}