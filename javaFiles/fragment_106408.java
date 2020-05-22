public static String getUserInput(Scanner keyboard) 
{
    String userInput;
    System.out.println("Enter your choice: ");
    userInput = keyboard.nextLine(); 
    while(!userInput.equals("rock")&&!userInput.equals("paper")&&!userInput.equals("scissors"))
    {
    System.out.println("Invalid Entry, Please re-enter your choice:");
    userInput = keyboard.nextLine();
    } //It wont go out of the loop unless it's one of the 3 choices

    return userInput;
}