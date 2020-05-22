final Scanner cmd = new Scanner(System.in);
String userInput = null;
do {
    System.out.print(">");
    userInput = cmd.nextLine();
    if (userInput.equals("help")) {
        help();
    } else if(userInput.equals("ping")) {
        ping();
    }
} while(userInput != null && !userInput.equals("quit"));