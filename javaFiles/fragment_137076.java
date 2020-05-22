public class IT145_Homework_5_4 
{
    public static void main(String args[])
    {

        double alpha[] = new double[50]; // all the values are whole numbers, why not make them of type int?

        // Initialize the first 25 elements of the array (int i=0; i<25; i++)
        for (int i = 0; i < 25; i++)
            alpha[i] = i * i;

        // Initialize the last 25 elements of the array (i=25; i<50; i++)
        for (int i = 25; i < 50; i++)
            alpha[i] = 3 * i;

        // Print the element of the array
        System.out.println("The values are: ");
        print(alpha);

        // Searches for value in array 
        double valueToFind = 100;
        if(find(alpha, valueToFind))
            System.out.println(valueToFind + " is in the array");
        else
            System.out.println(valueToFind + " is not in the array");

    }

    // Print method to display the element of the array
    private static void print(double m_array[])
    {
        for (int i = 1; i <= m_array.length; i++)
        {
            System.out.print(m_array[i - 1] + "\t\t");
            if (i % 10 == 0)
                System.out.print("\n");

        }
    }

    //Method to find element in array
    private static boolean find(double m_array[], double valueToFind)
    {
        for(int i = 0; i < m_array.length; i++) //remember that arrays start with index 0
            if(m_array[i] == valueToFind)
                return true;
        return false;
    }

}