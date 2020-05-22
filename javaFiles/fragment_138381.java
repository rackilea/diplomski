import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame{
    private ImageIcon cross = new ImageIcon ("FlowerX.jpg");
    ImageIcon not = new ImageIcon ("Owl.gif");

    public TicTacToe(){
        Container container = getContentPane();
        container.setLayout(new GridLayout(3, 3));

      }

      public static void main(String args[])
      {
          new TicTacToe();
      }

    }