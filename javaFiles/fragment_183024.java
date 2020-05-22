public static void main (String[] args)
{
    String clientName = "";
    Scanner keyboard = new Scanner(System.in);
    do
    {  
        System.out.println("Enter your Name: ");
        while (keyboard.hasNextInt())
        {
            System.out.println("That's not a name!");
            keyboard.next();
            System.out.println("Enter your Name: ");
        }
        clientName = keyboard.nextLine();
    } while (clientName.equals(""));
}