public static void main (String[] args)
{
    // Scanner is used for I/O
    Scanner input = new Scanner(System.in);

    // Prompt user to enter text
    System.out.println("Enter something ");

    // Get input from scanner by using next()
    String text = input.next();

    // this variable is used to store all previous entries
    String storage = "";

        // While the user does not enter -1, keep receiving input
        // Store user text into a running total variable (storage)
        while (!text.equals("-1")) {
            System.out.println("You entered: " + text);
            text = input.next();
            storage = storage + "\n" + text
    }
}