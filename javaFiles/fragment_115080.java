for (int i = 1; i < userInput; i += 2)//Draw the top of the diamond
{
    for (int j = 0; j < userInput - 1 - i / 2; j++)//Output correct number of spaces before
    {
        System.out.print(" ");
    }
    for (int j = 0; j < i; j++)//Output correct number of asterix
    {
        System.out.print("*");
    }

    System.out.print("\n");//Skip to next line
}

for (int i = userInput; i > 0; i -= 2)//Draw the bottom of the diamond
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