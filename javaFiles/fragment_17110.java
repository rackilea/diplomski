import javax.swing.JOptionPane;

public class Gain 
{
    // Defining array names.
    String[] name = {"A", “B”, “C”, “D”, “E”, “F”, “G”, “H”, “I”, “L”}; 
    int[][] hours = new int[10][3];

    public final int Hours() 
    {
        boolean canceled = false;
        for (int index = 0; index < name.length; index++)
        {
            JOptionPane.shoeMessageDialog("Please enter " + name[index] + "’s hours");
            for (int x = 0; x <= hours.length; x++)
            {
                for (int y = 0; y <= hours[x].length; y++)
                {
                    Integer value = promptForInt(artist[index] + “’s first hour: ”);
                    if (value != null)
                    {
                        while (value < 0)
                        {
                            JOptionPane.showMessageDialog(null, "Please positive figures." + "\nPlease try again.");
                            value = promptForInt(name[index] + “’s first hour: ”);
                        }
                        pay[x][y] = value;
                    } 
                    else
                    {
                        canceled = true;
                        break;
                    }
                }
            }

        }
    }

    public static void main(String[] args) // Main program
    {
        for (int x = 0; x <= name.length; x++)
           for (int y = 0; y <= hours.length; y++)
              System.out.println(x, y);
    }