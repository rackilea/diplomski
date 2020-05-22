import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example extends JFrame implements ActionListener {
    private JButton leftButton;
    private JButton rightButton;

    private CardLayout cardLayout = new CardLayout();
    JPanel cards = new JPanel(cardLayout);
    final static String LEFTPANEL = "LEFTPANEL";
    final static String RIGHTPANEL = "RIGHTPANEL";
    JPanel card1;
    JPanel card2;

    public Example()    {
        JPanel topPanel = new JPanel();
        addButtons(topPanel);

        add(topPanel, BorderLayout.NORTH);
        add(cards, BorderLayout.CENTER);

     //Initiates the card panels

        initCards();

        setTitle("My Window");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initCards() {
        card1 = new JPanel();
        card2 = new JPanel();
        card1.setBackground(Color.black);
        card2.setBackground(Color.red);

        cards.add(card1, LEFTPANEL);
        cards.add(card2, RIGHTPANEL);
    }

    private void addButtons(Container con)  {
        leftButton = new JButton("Left Button");
        leftButton.addActionListener(this);
        rightButton = new JButton("Right Button");
        rightButton.addActionListener(this);

        con.add(leftButton, BorderLayout.WEST);
        con.add(rightButton, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(leftButton))    {
            //Change cardlayout
            cardLayout.show(cards, LEFTPANEL);      
        } else if(e.getSource().equals(rightButton))    {
            //Change cardlayout
            cardLayout.show(cards, RIGHTPANEL);     
        }
    }

    public static void main(String[] args) {
        new Example();
    }

}