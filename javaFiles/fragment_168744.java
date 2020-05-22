import java.awt.*;
import javax.swing.*;

public class Worms extends JFrame{

    public static void main(String[] args) {
        new Worms();
    }

    private JButton startGame;
    public Worms(){
        JPanel menu = new JPanel();

        startGame = new JButton("Start Game"); 
        menu.add(startGame);
        this.add(menu);

        this.pack();
        // this should do what you seen to want
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // this is just polite..
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
}