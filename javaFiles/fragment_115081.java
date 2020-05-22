public static void main(String[] args)
{
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Welcome to the drawing program:");
    System.out.println("Please Input a Positive Odd Integer:");
    char userAnswer;
    int userInput;
    do
    {
        userInput = keyboard.nextInt();
        if (userInput % 2 == 0)
        {
            System.out.println("That is not an Odd Integer!");
        }
        if (userInput < 0)
        {
            System.out.println("That is not a Positive Odd Integer");
        }
    } while (userInput < 0 || userInput % 2 == 0);

    for (int i = 1; i < userInput; i += 2) //This is the number of iterations needed to print the top of diamond (from 1 to userInput by step of two for example with 5 = {1, 3, 5} so 3 rows.
    {
        for (int j = 0; j < userInput - 1 - i / 2; j++)//write correct number of spaces before, example with 5 = j < 5 - 1 -i / 2, so it would first print 4 spaces before, with 1 less untill it reach 0
        {
           System.out.print(" ");//write a space
        }
        for (int j = 0; j < i; j++)
        {
            System.out.print("*");//write an asterix
        }

        System.out.println("");
    }

    // Same logic apply here but backward as it is bottom of diamond
    for (int i = userInput; i > 0; i -= 2)
    {
        for (int j = 0; j < userInput -1 - i / 2; j++)
        {
            System.out.print(" ");
        }

        for (int j = 0; j < i; j++)
        {
            System.out.print("*");
        }

        System.out.print("\n");
    }

}