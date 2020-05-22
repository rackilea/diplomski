import java.util.Scanner;

public class LeapYears 
{

public static void main(String[] args) 
{
    int firstY, finalY, counter;
    counter = 0;
    Scanner kb = new Scanner(System.in);

    System.out.print("Enter start year: ");
    firstY = kb.nextInt();

    System.out.print("Enter end year: ");
    finalY = kb.nextInt();



    for(; firstY <= finalY; firstY++)

    {
        if ((firstY % 4) == 0)

        {
            if ((firstY % 100) == 0)

            {
                if ((firstY % 400) == 0 )

                {
                    System.out.print(firstY + ", ");
                    firstY++;
                    counter++;
                    if (counter % 10 == 0) System.out.println("");
                }
            }

            else
            {
                System.out.print(firstY + ", ");
            }

        }
    }

}
}