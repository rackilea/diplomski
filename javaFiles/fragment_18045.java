import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class ScrollPaneEg extends JPanel {
   private static final int PREF_W = 480;
   private static final int PREF_H = PREF_W;

   public ScrollPaneEg() {
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setViewportBorder(null);
      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

      JPanel container = new JPanel(new GridLayout(0, 1)); // 1 column variable
                                                           // number of rows
      for (int i = 0; i < 15; i++) {
         SingleClientPanel x = new SingleClientPanel(String.valueOf(i + 1));
         // x.setLocation(0, 45 *i);
         container.add(x);
      }
      scrollPane.setViewportView(container);

      setLayout(new BorderLayout());
      add(scrollPane, BorderLayout.CENTER);
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
     ScrollPaneEg mainPanel = new ScrollPaneEg();

      JFrame frame = new JFrame("ScrollPaneEg");
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

class SingleClientPanel extends JPanel {
   private static final int PREF_H = 60;

   public SingleClientPanel(String text) {
      setBorder(BorderFactory.createTitledBorder("Single Client"));
      setLayout(new GridBagLayout());
      add(new JLabel("Panel: " + text, SwingConstants.CENTER));
   }

   @Override
   public Dimension getPreferredSize() {
      Dimension superSz = super.getPreferredSize();
      if (isPreferredSizeSet()) {
         return superSz;
      }
      int prefH = Math.max(superSz.height, PREF_H);
      return new Dimension(superSz.width, prefH);
   }
}