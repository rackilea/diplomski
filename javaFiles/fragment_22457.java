import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

import javax.swing.*;

public class Initial {

   static AtomFrame atomLauncher;

   public static void main(String[] args) {

      atomLauncher = new AtomFrame();
      atomLauncher.start();

      System.out.println(Integer.MAX_VALUE);

      final Download theDownload = new Download();
      theDownload.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent pcEvt) {
            if ("progress".equals(pcEvt.getPropertyName())) {
               int progress = theDownload.getProgress();
               atomLauncher.setProgress(progress);
            }
         }
      });

      theDownload.execute();
   }

}

class AtomFrame extends JFrame {

   // ********* should be private!
   private JProgressBar progressBar;

   private static final long serialVersionUID = 4010489530693307355L;

   public static void main(String[] args) {
      AtomFrame testFrame = new AtomFrame();
      testFrame.start();
   }

   public void setProgress(int progress) {
      progressBar.setValue(progress);
   }

   public AtomFrame() {
      initializeComponents();
   }

   public void initializeComponents() {
      this.setSize(400, 400);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setTitle("Atom Launcher");
      this.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

      progressBar = new JProgressBar();
      this.add(progressBar);

      // this.pack();
   }

   public void start() {
      this.setVisible(true);
   }

   public void close() {
      this.dispose();
   }
}

class Download extends SwingWorker<Void, Void> {
   private static final long SLEEP_TIME = 300;
   private Random random = new Random();

   @Override
   protected Void doInBackground() throws Exception {
      int myProgress = 0;
      while (myProgress < 100) {
         myProgress += random.nextInt(10);
         setProgress(myProgress);
         try {
            Thread.sleep(SLEEP_TIME);
         } catch (InterruptedException e) {}
      }
      return null;
   }
}