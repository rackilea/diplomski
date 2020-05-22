import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;

public class RepaintTest extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private static final int LABEL_COUNT = 3;
   private static final String LABEL_PANEL = "label panel";
   private static final Object BLANK_COMPONENT = "blank component";
   private static final int TIMER_DELAY = 2000;
   private CardLayout cardLayout = new CardLayout();

   public RepaintTest() {
      JPanel labelPanel = new JPanel();
      for (int i = 0; i < LABEL_COUNT; i++) {
         labelPanel.add(new JLabel("Label " + (i + 1)));
      }

      setLayout(cardLayout);
      add(labelPanel, LABEL_PANEL);
      add(new JLabel(), BLANK_COMPONENT);

      new Timer(TIMER_DELAY, new TimerListener()).start();

   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         cardLayout.next(RepaintTest.this);
      }
   }

   private static void createAndShowGui() {
      RepaintTest mainPanel = new RepaintTest();

      JFrame frame = new JFrame("RepaintTest");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
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