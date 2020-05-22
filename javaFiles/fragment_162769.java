public static void main(String[] args)
{
    boolean validInput = false;
    Scanner scanner = new Scanner(System.in);
    while (!validInput)
    {
        System.out.println("*******************  Game  **********************");
        System.out.println("* (1) CPU vs Human                              *");
        System.out.println("* (2) CPU vs CPU                                *");
        System.out.println("* (3) Human vs CPU                              *");
        System.out.println("* (4) Highscore                                 *");
        System.out.println("* (5) End                                       *");
        System.out.println("-------------------------------------------------");
        System.out.println("Your choice:                                    ");

        try
        {

            // i used this so far but i get an error for entering a-z or other stuff than numbers
            int userInput = Integer.parseInt(scanner.nextLine().trim());
            //If no error took place, then the input is valid.
            validInput = true;

            //i have to use this but it doesnt work with switchcase - any suggestions?
            //String userInput = scanner.nextLine();                 
            switch (userInput)
            {
                case 1: // not written yet
                case 2: // not written yet
                case 3: // not written yet
                case 4: // not written yet
                case 5:
                    System.exit(0);
                default:
                    validInput = false;
                    System.out.println("Illegal userinput! Only enter numbers between 1 and 5!");
            }
        } catch (Exception e)
        {
            System.out.println("Invalid Input, please try again");
        }
    }
    scanner.close();
}