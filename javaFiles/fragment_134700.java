public static void main(final String... args)
{
    // Set of valid user inputs
    final Set<String> gameList = new HashSet<String>();
    // Object from which user inputs are read
    final Scanner in = new Scanner(System.in);

    // Introduction
    System.out.println("Hey there!!");
    System.out.println("Please tell us four game titles you like to play!!!");

    // What the user enters
    String input;

    // Check that 4 titles have been entered, don't get out of the loop until then
    while (gameList.size() < 4) {
        System.out.print("Enter the name of a game: ");
        // Read one input, trim all beginning and trailing whitespaces
        input = in.nextLine().trim();
        // If the resulting string is empty, input is invalid: ask for another
        if (input.isEmpty()) {
            System.out.println("Empty inputs not accepted!");
            continue;
        }
        if (!gameList.add(input))
            System.out.println("You have already selected this game (" + input + ')');
    }

    // Print out the list of inputs
    System.out.println("The list of selected games is: " + gameList);

}