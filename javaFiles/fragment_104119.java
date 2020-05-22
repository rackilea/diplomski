import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Testing extends JFrame {

    private JPanel cardHolder;
    private CardLayout cards;
    private static final String cardA = "A";
    private static final String cardB = "B";

    private class Switcher implements ActionListener{
        String card;        
        Switcher(String card) { this.card = card; }
        @Override
        public void actionPerformed(ActionEvent e) {
            cards.show(cardHolder, card);
        }
    }

    private void run() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel pa = new JPanel();
        JButton ba = new JButton("Switch to B");
        ba.addActionListener(new Switcher(cardB));
        pa.add(ba);
        pa.setBackground(Color.CYAN);

        JPanel pb = new JPanel();
        JButton bb = new JButton("Switch to A");
        bb.addActionListener(new Switcher(cardA));
        pb.add(bb);
        pb.setBackground(Color.MAGENTA);

        cardHolder = new JPanel();
        cards = new CardLayout();
        cardHolder.setLayout(cards);
        cardHolder.add(pa, cardA);
        cardHolder.add(pb, cardB);
        add(cardHolder);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    new testing().run();
                }
            });
        } catch (Exception ex) { }
    }
}