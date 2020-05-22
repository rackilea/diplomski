import java.awt.*;
import javax.swing.*;

public class CardTesting extends JFrame {

    CardLayout cl = new CardLayout();

    JPanel panel1, panel2;
    JPanel cardPanel;
    public CardTesting() {
        super("Card Layout Testing");
        setSize(400, 200);
        this.setLayout(cl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(cl);
        panel1 = new JPanel();
        panel2 = new JPanel();
        cardPanel=new JPanel();
        cardPanel.setLayout(cl);
        panel1.add(new JButton("Button 1"));
        panel2.add(new JButton("Button 2"));
        cardPanel.add(panel1, "Panel 1");
        cardPanel.add(panel2, "Panel 2");
        add(cardPanel);
        setVisible(true);
    }

    private void iterate() {
        /* the iterate() method is supposed to show the second card after Thread.sleep(1000), but cl.show(this, "Panel 2") throws an IllegalArgumentException: wrong parent for CardLayout*/
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        cl.show(cardPanel, "Panel 2");
    }

    public static void main(String[] args) {
        CardTesting frame = new CardTesting();
        frame.iterate();
    }
}