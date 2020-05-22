import javax.swing.JOptionPane;

public class SO {
public static void main(String[] args) {

JOptionPane.showMessageDialog(null, "JOptionPane show");
//*********************************************************************************
int response = JOptionPane.showConfirmDialog(null, "Is this helpful");
//do something based of int response....


//*********************************************************************************
String[] choices = {"Java", "C", "C#"};
int doAgain;

do {
    int responses = JOptionPane.showOptionDialog(
null                // center over parent
, "Favorite language"       // message
, "Poll"            // title in titlebar
, JOptionPane.YES_NO_OPTION // Option type
, JOptionPane.PLAIN_MESSAGE // message type
, null              // icon
, choices           // Options
, "None of your business"   // initial value
);

JOptionPane.showMessageDialog(null, "Response = " + responses);

doAgain = JOptionPane.showConfirmDialog(null, "Again?");
} while (doAgain == JOptionPane.YES_OPTION); //Loops if you choose to do again
//********************************************************************************* 
String input = JOptionPane.showInputDialog(null,
        "Please enter new quantity");
JOptionPane.showMessageDialog(null, input);
}
}