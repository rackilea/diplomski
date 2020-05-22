import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

public class MultipleBallsZ {

   private static void createAndShowGui() {
      BallsPanelZ ballsPanel = new BallsPanelZ();
      new Control(ballsPanel);

      JFrame frame = new JFrame("Multiple Balls");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(ballsPanel);
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
class BallsPanelZ extends JPanel {
   private static final int TIMER_DELAY = 200;
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;

   private Timer timer = new Timer(TIMER_DELAY, new TimerListener());
   private int counter = 0;
   private Control control = null;

   public BallsPanelZ() {
      timer.start();
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public Timer getTimer() {
      return timer;
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         counter++;
         System.out.printf("Count: %03d%n", counter);
      }
   }

   public void setControl(Control control) {
      this.control = control;
      for (Action action : control) {
         add(new JButton(action));
      }
   }
}

@SuppressWarnings("serial")
class Control implements Iterable<Action> {
   private List<Action> actionList = new ArrayList<>();
   private BallsPanelZ ballsPanel;

   public Control(BallsPanelZ ballsPanel) {
      actionList.add(new PauseAction());
      actionList.add(new ResumeAction());

      this.ballsPanel = ballsPanel;
      ballsPanel.setControl(this);
   }

   private class PauseAction extends AbstractAction {
      public PauseAction() {
         super ("Timer Pause");
         putValue(MNEMONIC_KEY, KeyEvent.VK_P);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         ballsPanel.getTimer().stop();
      }
   }

   private class ResumeAction extends AbstractAction {
      public ResumeAction() {
         super("Timer Resume");
         putValue(MNEMONIC_KEY, KeyEvent.VK_R);
         putValue(DISPLAYED_MNEMONIC_INDEX_KEY, 6);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         ballsPanel.getTimer().restart();
      }
   }

   @Override
   public Iterator<Action> iterator() {
      return actionList.iterator();
   }
}