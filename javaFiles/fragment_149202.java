import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class MyServerPanel extends JPanel {
   public MyServerPanel() {
      StopAction stopAction = new StopAction("Stop");
      StartAction startAction = new StartAction("Start", stopAction);
      add(new JButton(startAction));
   }

   private class StartAction extends AbstractAction {
      private Action nextAction;

      public StartAction(String name, Action nextAction) {
         super(name);
         int mnemonic = name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
         this.nextAction = nextAction;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         AbstractButton source = (AbstractButton) e.getSource();
         source.setAction(nextAction);
      }
   }

   private class StopAction extends AbstractAction {
      public StopAction(String name) {
         super(name);
         int mnemonic = name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         Component comp = (Component) e.getSource();
         Window win = SwingUtilities.getWindowAncestor(comp);
         if (win != null) {
            win.dispose();
         }
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("MyServerPanel");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new MyServerPanel());
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