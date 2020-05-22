public static void main(String[] args)
{
    Scanner scanner = new Scanner(System.in);
    handleInput(scanner);
}

public static void handleInput(Scanner scanner)
{
    System.out.println("Please input a command: ");
    boolean quitting = false;
    if(scanner.hasNextLine())
    {
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("help"))
        {
            System.out.println("This is the help menu!");
        }
        else if(input.equalsIgnoreCase("quit"))
        {
            System.out.println("Quitting!");
            quitting = true;
        }
        else 
        {
            System.out.println("I did not understand that command. Say 'help' for help.");
        }
    }

    if(!quitting)
        handleInput(scanner);
    else 
        scanner.close();
}