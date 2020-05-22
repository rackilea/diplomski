public static int first()
{
    System.out.print("Enter number: ")
    Scanner scan = new Scanner(System.in);
    int number = scan.nextInt();
    return number;
}

public static void getNumber(String name, int move)
{
    int number = first();   //Call method here.
    if (number == 1)
    {
        System.out.println("Player shows one" );
    }
}