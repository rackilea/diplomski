System.out.print(">");
final Scanner cmd = new Scanner(System.in);
String userInput = cmd.nextLine();
if (userInput.equals("help")) {
    help();
} else if(userInput.equals("ping")) {
    ping();
}