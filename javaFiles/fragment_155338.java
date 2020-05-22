public static void main(String[] args)
{
    // Prompt the user for the character they want
    Scanner scan = new Scanner(System.in);
    System.out.println("Pick a class:");
    System.out.println("Fighter: Deals more damage");
    System.out.println("Mage: Has more health");
    System.out.println("Theif: Deals less damage but has         more health");

    // Get the user's response
    String characterStr = scan.nextLine();

    Character user; // You might have to initialize this. Did not test
    if (characterStr.matches(".*Fighter.*"))
    {
        user = new Fighter();
    }
    else if (characterStr.matches(".*Mage.*"));
    { 
        user = new Mage();
    }        
    else if (characterStr.matches(".*Thief.*"));
    {
        user = new Thief();
    }
    else
    {
        user = new Human();
    }

    user.Name();
    user.Explore();

}