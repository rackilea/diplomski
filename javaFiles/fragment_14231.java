import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RPSSL implements ActionListener
{
  public String userPlayString;
  public String computerPlayString;

  public int c;
  public int p;

  public JButton rockButton = new JButton("Rock");
  public JButton paperButton = new JButton("Paper");
  public JButton scissorsButton = new JButton("Scissors");
  public JButton spockButton = new JButton("Spock");
  public JButton lizardButton = new JButton("Lizard");

  public JPanel panel = new JPanel();

  public static synchronized void main(String[] args) throws InterruptedException
  {
    RPSSL game = new RPSSL();
    game.createJFrame();
    while(game.c < 1)
    { 
      Thread.sleep(10);
      if (game.userPlayString != null) 
      {
        game.determineWinner();
        game.c++;
      }
    }
  }

  public RPSSL() 
  {
    userPlayString = null;
    computerPlayString = null;
    c = 0;
    p = 0;
  }

  public void actionPerformed(ActionEvent e) 
  {
    Object src = e.getSource();

    if (src == rockButton) 
    {
      userPlayString = "Rock";
      p = 1;
    }
    else if (src == paperButton) 
    {
      userPlayString = "Paper";
      p = 1;
    }
    else if (src == scissorsButton) 
    {
      userPlayString = "Scissors";
      p = 1;
    }
    else if (src == spockButton) 
    {
      userPlayString = "Spock";
      p = 1;
    }
    else if (src == lizardButton) 
    {
      userPlayString = "Lizard";
      p = 1;
    }
  }

  public void createJFrame() 
  {
    JFrame frame = new JFrame("Rock Paper Scissors Spock Lizard");
    panel.setLayout(null);

    panel.add(rockButton);
    rockButton.setBounds(0, 0, 100, 30);
    rockButton.addActionListener(this);

    panel.add(paperButton);
    paperButton.setBounds(0,30,100,30);
    paperButton.addActionListener(this);

    panel.add(scissorsButton);
    scissorsButton.setBounds(0,60,100,30);
    scissorsButton.addActionListener(this);

    panel.add(spockButton);
    spockButton.setBounds(0,90,100,30);
    spockButton.addActionListener(this);

    panel.add(lizardButton);
    lizardButton.setBounds(0,120,100,30);
    lizardButton.addActionListener(this);



    frame.add(panel);
    frame.setVisible(true);
    frame.setSize(30,200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void computerPlay() 
  {
    Random randomGenerator = new Random();
    int computerPlay = randomGenerator.nextInt(5);
    if (computerPlay == 0)
    {
      computerPlayString = "Rock";
    }
    else if (computerPlay == 1) 
    {
        computerPlayString = "Paper";
    }
    else if (computerPlay == 2) 
    {
        computerPlayString = "Scissors";
    }
    else if (computerPlay == 3) 
    {
        computerPlayString = "Spock";
    }
    else if (computerPlay == 4) 
    {
        computerPlayString = "Lizard";
    }

    System.out.println("Computer played: " + computerPlayString);

  }

  public void humanWins() 
  {
    System.out.print("You win!");
  }

  public void computerWins() 
  {
    System.out.print("You lose!");
  }

  public void tie() 
  {
    System.out.print("It's a tie!");
  }

  public void determineWinner() 
  {
    computerPlay();
    //Determines who wins
    if (userPlayString.equalsIgnoreCase("rock")) 
    {
        if (computerPlayString.equalsIgnoreCase("rock")) tie();
        else if (computerPlayString.equalsIgnoreCase("scissors")) humanWins();
        else if (computerPlayString.equalsIgnoreCase("paper")) computerWins();
        else if (computerPlayString.equalsIgnoreCase("spock")) humanWins();
        else if (computerPlayString.equalsIgnoreCase("lizard")) computerWins();
    }

    else if (userPlayString.equalsIgnoreCase("paper")) 
    {
        if (computerPlayString.equalsIgnoreCase("rock")) humanWins();
        else if (computerPlayString.equalsIgnoreCase("scissors")) computerWins();
        else if (computerPlayString.equalsIgnoreCase("paper"))tie();
        else if (computerPlayString.equalsIgnoreCase("spock")) humanWins();
        else if (computerPlayString.equalsIgnoreCase("lizard")) computerWins();
    }

    else if (userPlayString.equalsIgnoreCase("scissors")) 
    {
        if (computerPlayString.equalsIgnoreCase("rock")) computerWins();
        else if (computerPlayString.equalsIgnoreCase("scissors")) tie();
        else if (computerPlayString.equalsIgnoreCase("paper")) humanWins();
        else if (computerPlayString.equalsIgnoreCase("spock")) computerWins();
        else if (computerPlayString.equalsIgnoreCase("lizard")) humanWins();
    }

    else if (userPlayString.equalsIgnoreCase("spock")) 
    {
        if (computerPlayString.equalsIgnoreCase("rock")) computerWins();
        else if (computerPlayString.equalsIgnoreCase("scissors")) humanWins();
        else if (computerPlayString.equalsIgnoreCase("paper")) computerWins();
        else if (computerPlayString.equalsIgnoreCase("spock")) tie();
        else if (computerPlayString.equalsIgnoreCase("lizard")) humanWins();
    }

    else if (userPlayString.equalsIgnoreCase("lizard")) 
    {
        if (computerPlayString.equalsIgnoreCase("rock")) humanWins();
        else if (computerPlayString.equalsIgnoreCase("scissors")) computerWins();
        else if (computerPlayString.equalsIgnoreCase("paper")) humanWins();
        else if (computerPlayString.equalsIgnoreCase("spock")) computerWins();
        else if (computerPlayString.equalsIgnoreCase("lizard")) tie();
    }
  }
}