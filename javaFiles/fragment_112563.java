import java.util.*;
import javax.swing.JOptionPane;
public class Tutorial1  extends JFrame
 {


  static final double PINUM = 3.141592654;        // Declaring a constant

public static void main(String[] args) 
 {
  JFrame jf=new JFrame();
//JOptionPane.showMessageDialog(null,"");

int myInt = 4, i;            // Declares an integer
double myDouble;            // Declares Double
int[] myArray = new int[50]; // Declares Array

Scanner in = new Scanner(System.in);
System.out.println("\n\nWelcome! Please enter your name!");
String userName = in.nextLine();

System.out.println("Nice to meet you, " + userName + ".\n");

System.out.println("\nThe largest float this machine can create is = " +            Float.MAX_VALUE);
System.out.println("\nThe largest double this machien can create is = " +   Double.MAX_VALUE);

System.out.println("\nThis is a test Program for learning Java \nCreated by  " + userName 
        + "\n7/29/15\n\n"); // the + carries this line from the last

myInt++;
System.out.println("Value : " + myInt);

myDouble = 4.77;
myDouble = (myInt-1)/myDouble;

System.out.println("Value : " + myDouble + "\n");

for(myInt = 5; myInt >= 0; myInt--)
{
    System.out.println("Loop Value : " + myInt);
}

System.out.println("\n\nTesting Popup box...");
JOptionPane.showMessageDialog(jf,"Complete!");

System.out.println("\n\nTest Done");        
}
}