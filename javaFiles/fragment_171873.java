Scanner in = new Scanner(System.in);
System.out.print("Please choose.('e' to encrypt, 'd' to decrypt, 'q' to quit): ");
String userInput = in.nextLine();
if (userInput.equals("e"))
{
    System.out.println("Please enter your text that you want to encrypt: ");
    userInput = in.nextLine();

    System.out.print("Please enter your shift key(0-25): ");
    int userS = Integer.parseInt(in.nextLine());
    if (userS < 0 || userS > 25)
    {
        System.out.print("Invalid shift key, please enter a valid shift key: ");
        userS = Integer.parseInt(in.nextLine());
    }
}
in.close();