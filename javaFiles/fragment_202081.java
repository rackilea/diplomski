boolean validChoice = false;

while (!validChoice) {
    System.out.print(menuChoiceString);
    System.out.print("Enter Your Selection");
    menuChoice = SCANNER.nextLine();
    validChoice = testChoice(menuChoice);
}