Scanner input = new Scanner(System.in);
String command = "placeholder"; // magic at this line
while (!command.equals("quit")) {
    System.out.print("Write \"jump\" to jump; otherwise you quit: ");
    command = input.nextLine();
    switch (command) {
    case "jump":
        System.out.println("\nRound 1");
        break;
    case "quit":
        break;
    default:
        break;
    }
}