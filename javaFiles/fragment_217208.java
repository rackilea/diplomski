import java.io.*;
import javax.swing.JOptionPane;

public class MyType
{
    public static void main(String[] args)
    {
        // declare class variables
        String strChoice, strTryString, strTryInt, strTryDouble; /***/
        int choice, tryInt;
        double tryDouble;
        boolean done = false;
        boolean ok; /***/

        // loop while not done
        while(!done)
        {
            try
            {
                strChoice = JOptionPane.showInputDialog(null, "What's my type\n\n\n1) String\n2) integer\n3) double\n4) Quit the program");

                choice = Integer.parseInt(strChoice); /***/

                switch(choice)
                {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Correct, any input can be saved as a String.");
                        break;

                    case 2:
                        strTryInt = JOptionPane.showInputDialog(null,"Enter an integer"); /***/
                        ok = true;
                        try { /***/
                          tryInt = Integer.parseInt(strTryInt);
                        } catch(NumberFormatException e) { /***/
                          ok = false;     /***/
                        }
                        JOptionPane.showMessageDialog(null, ok?"Correct.":"Not an integer"); /***/
                        break;

                    case 3:
                        strTryDouble = JOptionPane.showInputDialog(null,"Enter a double"); /***/
                        tryDouble = Double.parseDouble(strTryDouble);
                        JOptionPane.showMessageDialog(null, "Correct.");
                        break;

                    case 4:
                        done = true;
                        JOptionPane.showMessageDialog(null, "The program will now close.");
                        break;

                    default:
                        throw new NumberFormatException();
                }
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null,"Please enter a 1, 2, 3, or 4.","Error",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}