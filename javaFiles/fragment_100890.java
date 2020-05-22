package Week5;

import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.Random;
import java.io.*;
//import helpers.*;TODO this import was no found but it is probably in your project

public class GuessGame extends JPanel{

private static int GUESS_MAX = 100;
private static int GUESS_MIN = 0;
private static int WINDOW_HEIGHT = 400;
private static int WINDOW_WIDTH = 325;
private Random random = new Random();
private int numberToGuess = 0;
private JFrame mainFrame;
private JButton tryButton;
private JButton newGameButton;
private ExitButton exitButton;
private JLabel guessLabel;
private JTextField guessField;
private JLabel headerLabel;
private JLabel countLabel;
private JLabel alertLabel;
private JPanel panel;

private JLabel cheat;
private JLabel cheat2;

public GuessGame(){ 
numberToGuess = 1 + random.nextInt(100);
mainFrame = new JFrame("Number Guessing Game");     
mainFrame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);          
mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
panel = new JPanel(new GridBagLayout());
mainFrame.getContentPane().add(panel, BorderLayout.NORTH);      
GridBagConstraints c = new GridBagConstraints();
c.insets = new Insets(10, 10, 10,10);       

tryButton = new JButton("Try the number");
newGameButton = new JButton("New Game");
exitButton = new ExitButton();
headerLabel = new JLabel("<html>I have a whole number between 1 and 100,<br>can you guess the   number?</html>", SwingConstants.CENTER);
guessLabel = new JLabel("Enter a guess:");
guessField = new JTextField(5);
countLabel = new JLabel("# of guesses: 0");
tryButton = new JButton("Try the number");      
alertLabel = new JLabel("Awaiting Input");
newGameButton = new JButton("New Game");
exitButton = new ExitButton();

cheat = new JLabel(String.valueOf(numberToGuess));
cheat2 = new JLabel("no value");

c.gridx = 0;
c.gridy= 0;
c.gridwidth = 2;
panel.add(headerLabel, c);      
c.gridwidth = 1;
c.gridx = 0;
c.gridy= 1;
panel.add(guessLabel, c);       
c.gridx = 1;
c.gridy= 1;
panel.add(guessField, c);       
c.gridx = 0;
c.gridy= 2;
c.gridwidth = 2;
panel.add(countLabel, c);       
c.gridx = 0;
c.gridy= 3;     
panel.add(tryButton, c);        
c.gridx = 0;
c.gridy= 4;
panel.add(alertLabel, c);       
c.gridwidth = 1;
c.gridx = 0;
c.gridy= 5;
panel.add(newGameButton, c);        
c.gridx = 1;
c.gridy= 5;
panel.add(exitButton, c);   
c.gridx = 0;
c.gridy = 6;
panel.add(cheat, c);
c.gridx = 1;
c.gridy = 6;
panel.add(cheat2, c);

newGameButton.setMnemonic('N');
NewGameButtonHandler nghandler = new NewGameButtonHandler();
newGameButton.addActionListener(nghandler);
tryButton.setMnemonic('T');
TryButtonHandler tryhandler = new TryButtonHandler();
tryButton.addActionListener(tryhandler);

mainFrame.setVisible(true);



}

//Me start - TODO this class was missing but you probably have it so just remove this.
class ExitButton extends JButton{   
}
//Me end

class NewGameButtonHandler implements ActionListener
{
public void actionPerformed(ActionEvent e)
{
numberToGuess = 1 + random.nextInt(100);
countLabel.setText("# of guesses: 0");
alertLabel.setForeground(Color.BLACK);
alertLabel.setText("Awaiting Input");
guessField.setText("");
cheat.setText(String.valueOf(numberToGuess));
//Me start
guessCount = 0;
lastDist = 0;
//Me end
}
}

//Me start
static int guessCount = 0;
static int lastDist = 0;
class TryButtonHandler implements ActionListener{

@Override
public void actionPerformed(ActionEvent e) {
    int guess;
    try{
        guess = Integer.parseInt(guessField.getText());
    }catch(NumberFormatException e){
        alertLabel.setText("That is not a number!");
        return;
    }
    if(guess < GUESS_MIN || guess > GUESS_MAX){
        alertLabel.setText("That number is out of range!");
        lastDist = distance(guess);
        guessCount++;
        return;
    }
    if(guessCount == 0){
        if(guess > numberToGuess){
            alertLabel.setText("Too high. ");
        }else if(guess < numberToGuess){
            alertLabel.setText("Too low. ");
        }
        lastDist = distance(guess);
        guessCount++;
        return;
    }
    if(guess == numberToGuess){
        alertLabel.setText("Correct!");
        alertLabel.setForeground(Color.GREEN);
        return;
    }
    int dist = distance(guess);
    if(dist < lastDist){
        alertLabel.setForeground(Color.RED);
        alertLabel.setText(" Getting warmer");
    }else if(dist > lastDist){
        alertLabel.setForeground(Color.BLUE);
        alertLabel.setText("Getting colder");
    }else{
        alertLabel.setForeground(Color.BLACK);
        alertLabel.setText("Why did you enter the same number?");
    }
    lastDist = dist;
    cheat2.setText(String.valueOf(guess));
    guessCount++;
}

private int distance(int guess){
    return numberToGuess - guess < 0 ? guess - numberToGuess : numberToGuess - guess;
}
}
//Me end

public static void main(String[] args) {
    new GuessGame();
}
}