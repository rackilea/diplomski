private static void displayMenu ()
{
    System.out.println ("Menu:");
    System.out.println ("\t1: Decode message");
    System.out.println ("\t2: Encode message");
    System.out.println ("\t3: Display alphabet");
    System.out.println ("\t4: Exit");
}

public static void main (String [] args)
{
    Scanner scanner = new Scanner (System.in);

    boolean done = false;
    while (!done)
    {
        displayMenu();

        switch (Integer.parseInt (scanner.nextLine ()))
        {
            case 1:
                System.out.println ("Decoding...");
                break;
            case 2:
                System.out.println ("Encoding...");
                break;
            case 3:
                System.out.println ("Displaying alphabet...");
                break;
            case 4:
                System.out.println("Exitting...");
                done = true;
                break;
            default:
                done = false;
        }
    }
}