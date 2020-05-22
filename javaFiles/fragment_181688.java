import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AppletEg extends JApplet {
   private static final int MAX_LOOP = 30;
   private static final long SLEEP_TIME = 500;
   private JFrame console;
   private JTextArea consoleText;
   private Thread gameThread;

   @Override
   public void init() {
      console = new JFrame();
      console.setSize(500, 300);
      console.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            console.setVisible(false);
         }
      });

      consoleText = new JTextArea();
      consoleText.setPreferredSize(new Dimension(500, 300));

      console.add(new JScrollPane(consoleText));

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
         System.out.println("I: " + i);
         try {
            Thread.sleep(SLEEP_TIME);
         } catch (InterruptedException e) {
         }
      }
   }
}