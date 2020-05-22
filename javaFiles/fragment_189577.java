import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class GameManager {
    JFrame frame;
    JPanel cards; // <-----
    Title title; // <-----

    public GameManager(){
        cards = new JPanel(new CardLayout());
        title = new Title(); // <-----
        cards.add(title,"title");
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, "title");
    }

    public static void main(String [] args){
        GameManager gm = new GameManager();
        gm.run();
    }

    public void run(){
        frame = new JFrame("Greek Olympics");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(cards);
        frame.setVisible(true);
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, "title");
    }

    public class Title extends JPanel { // <-----
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.fillRect(100,100,100,100);
        }
    }
}