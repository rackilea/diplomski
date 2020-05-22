import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardLayoutGUI
{
    private JFrame frame;
    private JButton btnBack;
    private JButton btnNext;
    private CardLayout cLayout;
    private JPanel panUp;
    private JPanel panDown;

    private static final String[] cards =
    {"card1", "card2", "card3", "card4", "card5"}; 

    private int currentCard = 0;

    public void init()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ((JPanel)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        btnBack = new JButton("Back");
        btnNext = new JButton("Next");

        btnBack.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                btnNext.setText("Next");
                currentCard--;
                cLayout.show(panUp, cards[currentCard]);
                if(currentCard == 0) btnBack.setVisible(false);
            }
        });

        btnNext.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                btnBack.setVisible(true);
                currentCard++;

                if(currentCard == cards.length - 1) // last card
                {
                    btnNext.setText("Exit");
                    cLayout.show(panUp, cards[currentCard]);
                }
                else if(currentCard >= cards.length)
                {
                    frame.setVisible(false);
                    frame.dispose();
                }
                else
                {
                    cLayout.show(panUp, cards[currentCard]);
                }
            }
        });


        cLayout = new CardLayout();
        panUp = new JPanel(cLayout);
        panDown = new JPanel();
        frame.add(panUp, BorderLayout.CENTER);
        frame.add(panDown, BorderLayout.SOUTH);
        panDown.add(btnBack);
        panDown.add(btnNext);

        for(int i = 0; i < cards.length; i++) createPanels(panUp, cards[i]);

        frame.pack();
        frame.setLocationRelativeTo(null);

        btnBack.setVisible(false);
    }

    public void showGUI()
    {
        frame.setVisible(true);
    }

    private void createPanels(JPanel container, String label)
    {
        JPanel pan = new JPanel();
        pan.add(new JLabel(label));
        container.add(pan, label);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                CardLayoutGUI clg = new CardLayoutGUI();
                clg.init();
                clg.showGUI();
            }
        });
    }
}