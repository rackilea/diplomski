import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SecretPhraseUI 
    extends JApplet
    implements ActionListener {

    SecretPhrase phrase = new SecretPhrase();
    JLabel passwordLabel = new JLabel("Enter a letter to guess the phrase."); //sets label to display message
    JLabel passwordLabel2 = new JLabel(
            phrase.hiddenPhrase  ); //sets label to display message
    JTextField inputBox = new JTextField(40); //sets text field
    JButton runButton = new JButton("Run"); //button that starts program
    Container con = getContentPane(); //gets container

    public void init() {
        con.setLayout(new FlowLayout());//sets flowlayout
        con.add(new JLabel());      //jlabel container
        con.add(inputBox);  //input box container
        con.add(runButton);  //run button container
        con.add(passwordLabel); //password label container
        con.add(passwordLabel2); //password label container
        runButton.addActionListener(this);//looks to see if run is clicked
        inputBox.addActionListener(this);//looks to see if input box is used
    }

    public void actionPerformed(ActionEvent e) {
        if (!inputBox.getText().isEmpty()) {
            phrase.changeLetter(
                    inputBox.getText().charAt(0)); //gets input from user 
            passwordLabel2.setText(phrase.hiddenPhrase);
        }
    }
}


public class SecretPhrase {
    int wrong = 0; //ignore for now
    String phrase = "Bad hair day"; //hidden, what the user has to guess
    String hiddenPhrase = "*** **** ***"; //what the user originally sees

    public void changeLetter(char input) {
         StringBuilder checker = new StringBuilder(hiddenPhrase);
         boolean wrongGuess = true;
         for (int i=0; i<phrase.length(); i++) {
            if (phrase.charAt(i) == input){
                checker.setCharAt(i, input);
                wrongGuess = false;
            }
         }
         hiddenPhrase = checker.toString();
         if (wrongGuess){
             wrong++;
         }
    }
}