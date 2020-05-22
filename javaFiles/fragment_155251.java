import java.util.Scanner;

class Unique
{
    public void getNumbers()
    {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int [5];
        int count = 0; // unique numbers read

        while (count < numbers.length)
        {
            System.out.print("Enter number: ");
            int number = input.nextInt();

            if (number >= 10 && number <= 100)
            {
                boolean containsNumber = false;

                for (int a = 0; a < numbers.length; a++)
                {
                    if (numbers[a] == number)
                    {
                        containsNumber = true;
                        break;
                    }
                }                 

                if (!containsNumber)
                {
                    numbers[count] = number;
                    count++;

                    System.out.printf("%d\n",number);
                }
                else
                {
                    System.out.printf("%d has already been entered\n", number);
                }
            }
            else 
            {
                System.out.println("number must be between 10 and 100");
            }

            for (int i = 0; i < count; i++)
            {
                System.out.printf("   %d\n", numbers[i]);
            }
        }
    }
}