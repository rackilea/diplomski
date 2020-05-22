public static boolean validation(String correct1, String correct2)
{
    Scanner in = new Scanner(System.in);
    String userInput;

    while (true)
    {
        System.out.print("Type in " + correct1 + " or " + correct2);
        userInput = in.next();

        if ( userInput.equals(correct1) )
        {
            return true;
        }
        else if ( userInput.equals(correct2) )
        {
            return false;
        }
        else
        {
            System.out.println("Try again!");
        }
    }

    return false; // Doesn't really matter, loop will never reach here
}