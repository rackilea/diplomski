//it is good practice to only import the packages you need
//so that you know exactly what you are dealing with
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LibraryFront {

    public static void main(String[] args) {
        //f1 is the JFrame
        //f1.getContentPane() would return the Container
        //but you do not actually need to add directly to it
        JFrame f1 = new JFrame();
        JPanel cards;
        final String BUTTONPANEL = "Card with JButtons";
        final String TEXTPANEL = "Card with JTextField";

        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();

        // Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL);
        cards.add(card2, TEXTPANEL);

        //adjust background colors just so you can see what is happening
        cards.setBackground(Color.GREEN);
        card1.setBackground(Color.RED);
        card2.setBackground(Color.BLUE);

        //set the layout to BorderLayout
        // add the cards JPanel to the center
        f1.setLayout(new BorderLayout());
        f1.add(cards, BorderLayout.CENTER);
        f1.setSize(400, 300);
        f1.setTitle("Test Frame");
        f1.setVisible(true);
    }
}