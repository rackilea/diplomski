import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;
import javax.swing.*;

public class Main {

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            JFrame jf = new JFrame("hi!");
            JPanel mainPanel = new JPanel(new GridLayout());
            JButton testSystemOut = new JButton("test System.out");
            testSystemOut.addActionListener(new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent e) {
                  System.out.println("this is a test");
               }
            });
            mainPanel.add(new JButton(new LongAction("Long Action")));
            mainPanel.add(new JButton(new TimerAction("Timer Action")));
            mainPanel.add(testSystemOut);
            jf.add(mainPanel);
            jf.pack();          
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setVisible(true);
         }
      });
   }

   @SuppressWarnings("serial")
   public static class LongAction extends AbstractAction {
      private LongWorker longWorker = null;

      public LongAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         setEnabled(false);
         longWorker = new LongWorker(); // create a new SwingWorker

         // add listener to respond to completion of the worker's work
         longWorker.addPropertyChangeListener(new LongWorkerListener(this));

         // run the worker
         longWorker.execute();
      }
   }

   public static class LongWorker extends SwingWorker<Void, Void> {
      private static final long SLEEP_TIME = 3 * 1000;

      @Override
      protected Void doInBackground() throws Exception {
         Thread.sleep(SLEEP_TIME);

         System.out.println("Finished with long action!");
         return null;
      }
   }

   public static class LongWorkerListener implements PropertyChangeListener {
      private LongAction longAction;

      public LongWorkerListener(LongAction longAction) {
         this.longAction = longAction;
      }

      @Override
      public void propertyChange(PropertyChangeEvent evt) {
         if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
            // if the worker is done, re-enable the Action and thus the JButton
            longAction.setEnabled(true);
            LongWorker worker = (LongWorker) evt.getSource();
            try {
               // call get to trap any exceptions that might have happened during worker's run
               worker.get();
            } catch (InterruptedException e) {
               e.printStackTrace();
            } catch (ExecutionException e) {
               e.printStackTrace();
            }
         }
      }
   }

   @SuppressWarnings("serial")
   public static class TimerAction extends AbstractAction {
      private static final int TIMER_DELAY = 3 * 1000;

      public TimerAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         setEnabled(false);
         new Timer(TIMER_DELAY, new TimerListener(this)).start();
      }
   }

   public static class TimerListener implements ActionListener {
      private TimerAction timerAction;

      public TimerListener(TimerAction timerAction) {
         this.timerAction = timerAction;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         timerAction.setEnabled(true);
         System.out.println("Finished Timer Action!");
         ((Timer) e.getSource()).stop();
      }
   }
}