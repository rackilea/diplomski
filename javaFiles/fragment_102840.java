import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class Driver {

   public static void main(String[] args) {
      Controller con = new Controller();
      con.ask();
   }
}

class Controller {

   private View theView = new View();
   private Model theModel = new Model();

   public void ask() {
      theView.displayMenu();

      if (cont(theView)) {
         System.out.println("ready");
         theView.setView(View.GAME);
      }
   }

   private boolean cont(View theView) {
      int result = JOptionPane.showConfirmDialog(theView, "Go on to game?");
      return result == JOptionPane.YES_OPTION;
   }
}

class View extends JFrame {

   private static final long serialVersionUID = 1L;
   public static final String START = "start";
   public static final String GAME = "game";
   private String String1 = "1";
   private String String2 = "2";
   private CardLayout cardLayout = new CardLayout();

   View() {
      // setVisible(true); // don't call this til all added to gui
      setTitle("Tic-Tac-Toe");
      // setSize(400, 400); 
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      getContentPane().setLayout(cardLayout);
      add(new StartMenu(), START);
      add(new GameScreen(), GAME);

      pack();
      setVisible(true);
   }

   public void displayMenu() {
      this.add(new StartMenu());
   }

   public void setView(String constant) {
      cardLayout.show(getContentPane(), constant);
   }

   // class names should begin with an upper case letter
   class StartMenu extends JPanel {
      private static final int PREF_W = 400;
      private static final int PREF_H = PREF_W;

      private static final long serialVersionUID = 1L;

      private StartMenu() {
         setVisible(true);
      }

      @Override
      public Dimension getPreferredSize() {
         return new Dimension(PREF_W, PREF_H);
      }

      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         setBackground(Color.blue);

         g.setColor(Color.black);
         g.drawString(String1, this.getWidth() / 2, this.getHeight() / 2);
      }

   }

   // class names should begin with an upper case letter
   class GameScreen extends JPanel {

      private static final long serialVersionUID = 1L;

      private GameScreen() {
         setVisible(true);
      }

      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         setBackground(Color.green);
         g.setColor(Color.black);
         g.drawString(String2, this.getWidth() / 2, this.getHeight() / 2);
      }

   }
}

class Model {

}