import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

import javax.swing.*;

public class MyLoadingTester extends JPanel {
   public MyLoadingTester() {
      add(new JButton(new LoadingAction()));
   }

   private class LoadingAction extends AbstractAction {
      public LoadingAction() {
         super("Load");
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         final MyWorker myWorker = new MyWorker();
         Window win = SwingUtilities.getWindowAncestor(MyLoadingTester.this);
         final MyLoadingDialogPanel myLoadingDialogPanel = new MyLoadingDialogPanel("Loading a Bunch of Chit");
         final JDialog dialog = new JDialog(win, "Loading", ModalityType.APPLICATION_MODAL);
         dialog.add(myLoadingDialogPanel);
         dialog.pack();
         dialog.setLocationRelativeTo(win);

         myWorker.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
               if ("progress".equals(evt.getPropertyName())) {
                  int progress = ((Integer) evt.getNewValue()).intValue();
                  myLoadingDialogPanel.setProgress(progress);
               } else if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                  dialog.dispose();
               }
            }
         });
         myWorker.execute();
         dialog.setVisible(true);
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("TestLoadingScreen");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new MyLoadingTester());
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

class MyLoadingDialogPanel extends JPanel {
   private JProgressBar progressBar = new JProgressBar(0, 100);

   public MyLoadingDialogPanel(String text) {
      progressBar.setStringPainted(true);

      setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      setLayout(new BorderLayout());

      JLabel label = new JLabel(text, SwingConstants.CENTER);
      label.setFont(label.getFont().deriveFont(Font.BOLD, 18f));
      add(label, BorderLayout.PAGE_START);
      add(progressBar, BorderLayout.CENTER);
   }

   public void setProgress(int progress) {
      progressBar.setValue(progress);
   }
}

class MyWorker extends SwingWorker<Void, Void> {
   private static final int MAX = 100;
   private int myProgress = 0;
   private Random random = new Random();

   @Override
   protected Void doInBackground() throws Exception {
      // TODO put long-running code here
      // Load some of the things I need to load.
      // ..... call setProgress(...) as you're doing it
      // Load the rest of the things I need to load.

      // as an example
      while (myProgress < MAX) {
         myProgress += random.nextInt(5) + 5;
         Thread.sleep(200);
         setProgress(Math.min(MAX, myProgress));
      }
      return null;
   }
}