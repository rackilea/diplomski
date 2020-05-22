import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PeeskilletsRPS extends JPanel{

    // buttons
    JButton P1Rock = new JButton("Rock");
    JButton P1Paper = new JButton("Paper");
    JButton P1Scissors = new JButton("Scissors");
    JButton P2Rock = new JButton("Rock");
    JButton P2Paper = new JButton("Paper");
    JButton P2Scissors = new JButton("Scissors");
    JButton jbtPlay = new JButton("Play");

    // panels
    JPanel namesPanel;
    JPanel player1Panel;
    JPanel player2Panel;

    // finish panel
    JPanel finishPanel;
    JButton playAgain;
    JLabel result;

    // CardLayout and main Panel
    CardLayout cardLayout;
    JPanel cardPanel;

    String player1Choice;
    String player2Choice;
    String status;

    String player2Name;
    String player1Name;


    public PeeskilletsRPS(){
        // names panel
        JPanel p1 = new JPanel(new GridLayout(4,1));
        p1.add(new JLabel("Player 1 Name: "));
        final JTextField jtfname1 = new JTextField(15);
        p1.add(jtfname1);
        p1.add(new JLabel("Player 2 Name: "));
        final JTextField jtfname2 = new JTextField(15);
        p1.add(jtfname2);
        namesPanel = new JPanel(new BorderLayout());
        namesPanel.add(p1, BorderLayout.CENTER);
        namesPanel.add(jbtPlay, BorderLayout.SOUTH);

        // player 1 panel
        JPanel player1Buttons = new JPanel();
        player1Buttons.add(P1Rock);
        player1Buttons.add(P1Paper);
        player1Buttons.add(P1Scissors);
        player1Panel = new JPanel(new BorderLayout());
        player1Panel.add(player1Buttons, BorderLayout.SOUTH);
        final JLabel jlblPlayer1 = new JLabel("  ");
        jlblPlayer1.setHorizontalAlignment(JLabel.CENTER);
        player1Panel.add(jlblPlayer1, BorderLayout.CENTER);

        // player 2 panel
        JPanel player2Buttons = new JPanel();
        player2Buttons.add(P2Rock);
        player2Buttons.add(P2Paper);
        player2Buttons.add(P2Scissors);
        player2Panel = new JPanel(new BorderLayout());
        player2Panel.add(player2Buttons, BorderLayout.SOUTH);
        final JLabel jlblPlayer2 = new JLabel("  ");
        jlblPlayer2.setHorizontalAlignment(JLabel.CENTER);
        player2Panel.add(jlblPlayer2, BorderLayout.CENTER);

        // finish panel
        result = new JLabel("  ");
        playAgain = new JButton("Play Agian");
        finishPanel = new JPanel(new BorderLayout());
        finishPanel.add(playAgain, BorderLayout.SOUTH);
        finishPanel.add(result, BorderLayout.CENTER);
        result.setHorizontalAlignment(JLabel.CENTER);

        // create card layout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(namesPanel, "names");
        cardPanel.add(player1Panel, "player1");
        cardPanel.add(player2Panel, "player2");
        cardPanel.add(finishPanel, "finish");

        // add cardPanel to main panel
        add(cardPanel);

        P1Rock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                player1Choice = "Rock";
                cardLayout.show(cardPanel, "player2");
            }
        });
        P1Paper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player1Choice = "Paper";
                cardLayout.show(cardPanel, "player2");
            }
        });
        P1Scissors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player1Choice = "Scissors";
                cardLayout.show(cardPanel, "player2");
            }
        });

        P2Rock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player2Choice = "Rock";
                checkWinner();
                result.setText(status);
                cardLayout.show(cardPanel, "finish");
            }
        });

        P2Paper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player2Choice = "Paper";
                checkWinner();
                result.setText(status);
                cardLayout.show(cardPanel, "finish");
            }
        });

        P2Scissors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player2Choice = "Scissors";
                checkWinner();
                result.setText(status);
                cardLayout.show(cardPanel, "finish");
            }
        });

        jbtPlay.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                player1Name = jtfname1.getText();
                player2Name = jtfname2.getText();
                jlblPlayer1.setText(player1Name + " choose: ");
                jlblPlayer2.setText(player2Name + " choose: ");
                cardLayout.show(cardPanel, "player1");

            }
        });

        playAgain.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "player1");
            }
        });
    }

    private void checkWinner(){
        if (player1Choice.equals(player2Choice)) 
            status = "It's a Tie!";
        else if ("Rock".equals(player1Choice) && "Paper".equals(player2Choice))
            status = player2Name + " wins. Paper beats Rock!";
        else if ("Rock".equals(player1Choice) && "Scissors".equals(player2Choice))
            status = player1Name + " wins. Rock beats Scissors!";
        else if ("Paper".equals(player1Choice) && "Rock".equals(player2Choice))
            status = player1Name + " wins. Paper beats Rock!";
        else if ("Paper".equals(player1Choice) && "Scissors".equals(player2Choice))
            status = player2Name + " wins. Scissors beats Paper!";
        else if ("Scissors".equals(player1Choice) && "Paper".equals(player2Choice))
            status = player1Name + " wins. Scissors beats Paper!";
        else if ("Scissors".equals(player1Choice) && "Rock".equals(player2Choice))
            status = player2Name + " wins. Rock beats Scissors!";   
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                JFrame frame = new JFrame("Peeskillet's Rock, Paper, Scissors");
                frame.add(new PeeskilletsRPS());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}