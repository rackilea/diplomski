import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Game2 extends JPanel {
   private static final int PREF_W = 300;
   private static final int PREF_H = PREF_W / 16 * 9;
   private static final int SCALE = 3;
   private static final Color BACKGROUND = Color.BLACK;
   private static final int TIMER_DELAY = 20;
   private Timer swingTimer;

   public Game2() {
      setBackground(BACKGROUND);
      swingTimer = new Timer(TIMER_DELAY, new TimerListener());
      swingTimer.start();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);   
      // TODO: add any custom painting here
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W * SCALE, PREF_H * SCALE);
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO add code that gets called in game loop
      }
   }

   private static void createAndShowGui() {
      Game2 mainPanel = new Game2();

      JFrame frame = new JFrame("Game2");
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