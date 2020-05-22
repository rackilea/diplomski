Scanner sc = new Scanner(System.in);
String input = sc.nextLine();
try {
    playerChoice = Integer.parseInt(input);
} catch (NumberFormatException e) {
    if (input.equalsIgnoreCase("rock")) {
        playerChoice = rock;
    } else if (input.equalsIgnoreCase("paper")) {
        playerChoice = paper;
    } else if (input.equalsIgnoreCase("scissors")) {
        playerChoice = scissors;
    } else {
        // if input is invalid
        playerChoice = -1;
    }
}