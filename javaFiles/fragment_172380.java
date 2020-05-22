String diceChoice;

do {
    diceChoice = scan.nextLine();
    if (diceChoice.matches("\\d+")) break;
    System.out.println("Please enter a number-only choice");
} while (true);

int diceChoiceInt = Integer.parseInt(diceChoice);