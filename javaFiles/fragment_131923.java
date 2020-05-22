public static void main(String[] args)

{
    int times = 0; // To keep track of the times the charcater appears in
                    // the String
    String str1; // To get the string you want to check
    String str2; // To get the string for the character you want to check in
                    // the String.

    Scanner keyboard = new Scanner(System.in);

    // Get the string you want to check
    boolean stopping = false;
    while (!stopping) {
        System.out
                .print("Enter the string you want to check: (enter 'end' to stop)");
        str1 = keyboard.nextLine();
        stopping = "end".equalsIgnoreCase(str1.trim());
        if (!stopping) {

            // To get the character
            System.out.print("Enter the character you want to check: ");
            str2 = keyboard.nextLine();
            if (str2.length() > 1) {
                str2 = str2.substring(0, 1);
            }

            times = 0;
            int loc = -1;
            while ((loc = str1.indexOf(str2, loc + 1)) > -1) {
                times++;
            }

            System.out.println("Results: '" + str2 + "' appears " + times
                    + " times in string " + str1);
        }

    }
    keyboard.close();
    System.out.println("Thanks");

}

}