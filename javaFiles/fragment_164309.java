import java.awt.*; //Import everything
import java.util.*;
import java.awt.event.*;
import javax.swing.*; //Seriously, everything, just makes this easier

public class Keypad extends JPanel implements ActionListener {

public static void main(String[] args) {
//Create the frame that holds everything else
JFrame frame = new JFrame ("Almost Functional Keypad");
frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

//Create the keypad
frame.getContentPane().add(getKeypad());

//Stuff to do so it won't break
frame.setPreferredSize(new Dimension(350,400));
frame.pack();
frame.setVisible(true);
frame.setResizable(false);
}

public static JPanel getKeypad(){
//Create the array of JPanels and labels

Keypad obj = new Keypad();
JButton[] keyList = new JButton[12];
JLabel[] keyLabel = new JLabel[12];

//Array with the key labels
String[] keyLabelText = {"1","2","3","4","5","6","7","8","9","*","0","#"};

//We need a counter
int i;

//Create the panels
for (i=0; i<12; i++){
    keyList[i]= new JButton();
    keyList[i].setPreferredSize (new Dimension(100, 75));
    keyLabel[i] = new JLabel (keyLabelText[i]);
    keyList[i].add (keyLabel[i]);
    keyList[i].addActionListener(obj);
}

//Text field that only the buttons can modify
JTextArea displayText = new JTextArea();
displayText.setPreferredSize(new Dimension(320, 20));

//Create the "clear" button
JButton clear = new JButton();
clear.setPreferredSize(new Dimension(300, 40));
JLabel clearLabel = new JLabel ("Clear");
clear.add(clearLabel);
clear.addActionListener(obj);

// Set up primary panel
JPanel primary = new JPanel();
primary.add(displayText);
for (i=0; i<12; i++){
    primary.add (keyList[i]);
}
primary.add(clear);
return primary;
}

public void actionPerformed (ActionEvent event){
    //Stuff goes here eventually
    // use it like this
    //if(event.getSource()==whateveryouwanttotest){
    //
    //}
}
}