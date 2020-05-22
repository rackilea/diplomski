import javax.swing.JOptionPane;

public class test
{
    public static void main (String[] args) throws NumberFormatException
    {
        String input;
        int number;

        while (true)
        {
            try
            {
                input = JOptionPane.showInputDialog("Enter an integer: ");      //creates input box for user to enter integer value
                number = Integer.parseInt(input);

                System.out.println("You entered: " + number);
                break;
            }
            catch (NumberFormatException e)
            {
                // do nothing
            }
       }
   }
}