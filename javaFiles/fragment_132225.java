import javax.swing.JOptionPane;

public class test
{
    public static void main (String[] args) throws NumberFormatException
    {
        String input;
        boolean x = false;
        int number;

        while (x == false)
        {
            try
            {
                input = JOptionPane.showInputDialog("Enter an integer: ");      //creates input box for user to enter integer value
                number = Integer.parseInt(input);

                if ( number < -2147483648 || number > 2147483647)
                {
                    x = false;
                }
                else
                {
                    x = true;
                    System.out.println("You entered: " + number);
                }
            }
            catch (NumberFormatException e)
            {
                continue;
            }
       }
   }
}