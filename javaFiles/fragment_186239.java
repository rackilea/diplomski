import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class BbbTest extends JFrame {

   private AreaOfGame areaOfGame;

   public BbbTest() {
      super("");
//      setVisible(true);
      this.setBackground(Color.darkGray);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.pack();
      setLayout(null);
      setBounds(200, 10, 400, 700);

      areaOfGame = new AreaOfGame();
      this.add(areaOfGame);
      setVisible(true);

      startGame();
   }

   public int generateNext() {
      Random r = new Random();
      int n = r.nextInt(7);
      return n;
   }

   public void startGame() {
      // while (!areaOfGame.GameOver()) {
      // areaOfGame.startGame(generateNext());
      // }

      areaOfGame.startGame(generateNext());
   }

   public static void main(String[] args) {
      new BbbTest();
   }

   class AreaOfGame extends JPanel {

      private static final int rightside = 370;

      private int bottom;
      private int top;

      private int currentPos;
      private int currentver;
      private KeyLis listener;

      public AreaOfGame() {
         super();

         bottom = 650;
         top = 50;
         setLayout(null);
         setBounds(20, 50, 350, 600);
         setVisible(true);

         this.setBackground(Color.lightGray);

         listener = new KeyLis();
         this.setFocusable(true);
         if (this.requestFocus(true))
            System.out.println("true");
         ;
         this.addKeyListener(listener);

         currentPos = 150;
         currentver = 0;
      }

      public void startGame(int n) {
         // while (verticallyInBound()) {
         // System.out.println("anything");
         // }

         int timeDelay = 50; // msecs delay
         new Timer(timeDelay , new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
               System.out.println("anything");
            }
         }).start();

      }

      public boolean verticallyInBound() {
         if (currentPos <= bottom - 50)
            return true;
         return false;
      }

      public boolean GameOver() {
         if (top >= bottom) {
            System.out.println("game over");
            return true;
         }

         else
            return false;
      }

      public boolean horizontalyInBounds() {
         if (currentPos <= rightside && currentPos >= 20)
            return true;
         else
            return false;
      }

      class KeyLis implements KeyListener {

         @Override
         public void keyPressed(KeyEvent e) {
            System.out.println("called");
            currentver += 5;
            switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
               if (horizontalyInBounds())
                  currentPos -= 5;
               break;
            case KeyEvent.VK_RIGHT:
               if (horizontalyInBounds())
                  currentPos += 5;
               break;
            }
            repaint();

         }

         @Override
         public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

         }

         @Override
         public void keyTyped(KeyEvent e) {
            System.out.println("called 3");
         }
      }
   }
}