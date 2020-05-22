import java.util.Scanner;

public class InputParser
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter  values: ");
        int sumIntegers = 0;
        int countIntegers = 0;
        double sumDoubles = 0.0;
        int countDoubles = 0;
        StringBuilder sumString = new StringBuilder();
        int countStrings = 0;

        while (scanner.hasNextLine())
        {
            if (scanner.hasNextInt())
            {
                countIntegers++;
                sumIntegers += scanner.nextInt();
            }
            else if (scanner.hasNextDouble())
            {
                countDoubles++;
                sumDoubles += scanner.nextDouble();
            }
            else
            {
                String str = scanner.next();
                if (str.equalsIgnoreCase("quit"))
                {
                    break;
                }
                else {
                    ++countStrings;
                    sumString.append( str );
                }
            }
        }
        System.out.println("Number of integers: " + countIntegers);
        System.out.println("Sum of integers: " + sumIntegers);
        System.out.println("Number of doubles: " + countDoubles);
        System.out.println("Sum of doubles: " + sumDoubles);
        System.out.println("Number of strings: " + countStrings);
        System.out.println("concatenated string: " + sumString.toString());

        scanner.close();
    }
}