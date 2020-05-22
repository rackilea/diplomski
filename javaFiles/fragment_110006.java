Scanner input = new Scanner(System.in);
String command = "placeholder"; // magic at this line
while (!command.equals("quit")) {
    System.out.println("Write \"jump\" to jump; otherwise you quit: ");
    command = input.nextLine();
    if (command.equals("quit"))
        continue;
    System.out.println("\nRound 1");
}