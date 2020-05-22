String [] userNames = {"Jack", "Jill"};  
logIn(userNames);

public static void logIn(String [] name)
{
    String userName = "";
    Scanner kb = new Scanner(System.in);
    System.out.print("Enter Username: ");
    userName = kb.nextLine();
    //while (userName != name[0] || userName != name[1])
    while (!userName.equals(name[0]) && !userName.equals(name[1]))
    {
        System.out.print("Enter Username: ");
        userName = kb.nextLine();
    }
    System.out.println("Correct");
}