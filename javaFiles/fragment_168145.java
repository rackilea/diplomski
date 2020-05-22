import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class TimerSpeedEg extends JPanel {
   private static final int BI_W = 150;
   private static final int BI_H = BI_W;
   private static final int SHOW_TRICKS_COUNT = 3;
   private List<Icon> icons;
   private Random random = new Random();
   private List<ShowTricks> showTricksList = new ArrayList<>();

   public TimerSpeedEg() {
      icons = createIcons();


      setLayout(new GridLayout(1, 0));
      add(createShowTricksPanel(BI_W, BI_H, "Fast", 100, false));
      add(createShowTricksPanel(BI_W, BI_H, "Slow", 1000, false));
      add(createShowTricksPanel(BI_W, BI_H, "Self-Paced", 0, true));

   }

   private JPanel createShowTricksPanel(int w, int h, String title,
         int speed, boolean selfPaced) {
      final ShowTricks showTricks = new ShowTricks(w, h);
      TrickSettings trickSettings = new TrickSettings(speed, selfPaced);
      for (Icon icon : icons) {
         trickSettings.addIcon(icon);
      }
      showTricks.setTrickSettings(trickSettings );
      JButton showButton = new JButton(new AbstractAction("Show") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            showTricks.show();
         }
      });
      JPanel btnPanel = new JPanel();
      btnPanel.add(showButton);
      JPanel panel = new JPanel(new BorderLayout());
      panel.setBorder(BorderFactory.createTitledBorder(title));
      panel.add(showTricks.getTrickLabel(), BorderLayout.CENTER);
      panel.add(btnPanel, BorderLayout.SOUTH);
      return panel;
   }

   private List<Icon> createIcons() {
      List<Icon> iconList = new ArrayList<Icon>();
      String[] strings = { "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten" };
      for (int i = 0; i < strings.length; i++) {
         JLabel label = new JLabel(strings[i], SwingConstants.CENTER);
         label.setSize(BI_W, BI_H);
         label.setOpaque(true);
         Color color = new Color(random.nextInt(127) + 127,
               random.nextInt(127) + 127, random.nextInt(127) + 127);
         Color borderColor = new Color(color.getRed() - 100,
               color.getGreen() - 100, color.getBlue() - 100);
         label.setBackground(color);
         label.setBorder(BorderFactory.createLineBorder(borderColor, 20));
         BufferedImage bImg = new BufferedImage(BI_W, BI_H,
               BufferedImage.TYPE_INT_ARGB);
         Graphics g = bImg.getGraphics();
         label.paint(g);
         g.dispose();
         iconList.add(new ImageIcon(bImg));
      }
      return iconList;
   }

   private static void createAndShowGui() {
      TimerSpeedEg mainPanel = new TimerSpeedEg();

      JFrame frame = new JFrame("TimerSpeedEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

class ShowTricks {
   int prefW;
   int prefH;
   private JLabel trickLabel = new JLabel() {
      @Override
      public Dimension getPreferredSize() {
         return new Dimension(prefW, prefH);
      }
   };

   public ShowTricks(int prefW, int prefH) {
      this.prefW = prefW;
      this.prefH = prefH;
   }

   private TrickSettings trickSettings;

   public JLabel getTrickLabel() {
      return trickLabel;
   }

   public void setTrickSettings(TrickSettings trickSettings) {
      this.trickSettings = trickSettings;
   }

   public void show() {
      if (trickSettings == null) {
         return;
      }
      if (trickSettings.isSelfPaced()) {
         showSelfPaced();
      } else {
         showWithTimer();
      }
   }

   private void showWithTimer() {
      Timer timer = new Timer(trickSettings.getMiliseconds(), new TimerListener());
      timer.setInitialDelay(0);
      timer.start();
   }

   private void showSelfPaced() {
      trickLabel.setIcon(trickSettings.getIcon(0));
      trickLabel.addMouseListener(new MouseAdapter() {
         private int count = 1;

         @Override
         public void mousePressed(MouseEvent e) {
            if (count < trickSettings.getSize()) {
               trickLabel.setIcon(trickSettings.getIcon(count));
               count++;
            } else {
               trickLabel.removeMouseListener(this);
            }
         }
      });
   }

   private class TimerListener implements ActionListener {
      private int count = 0;

      @Override
      public void actionPerformed(ActionEvent evt) {
         if (count < trickSettings.getSize()) {
            trickLabel.setIcon(trickSettings.getIcon(count));
            count++;
         } else {
            ((Timer) evt.getSource()).stop();
         }
      }
   }
}

class TrickSettings implements Iterable<Icon> {
   private List<Icon> icons = new ArrayList<Icon>();
   private int miliseconds;
   private boolean selfPaced;

   public TrickSettings(int miliseconds, boolean selfPaced) {
      this.miliseconds = miliseconds;
      this.selfPaced = selfPaced;
   }

   public int getSize() {
      return icons.size();
   }

   public int getMiliseconds() {
      return miliseconds;
   }

   public boolean isSelfPaced() {
      return selfPaced;
   }

   @Override
   public Iterator<Icon> iterator() {
      return icons.iterator();
   }

   public Icon getIcon(int index) {
      return icons.get(index);
   }

   public void addIcon(Icon icon) {
      icons.add(icon);
   }
}