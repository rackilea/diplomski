if (num1 == 1 && num2 == 1) {
    playerTotal = 0;
}
else if (num1 != 1 && num2 != 1) {
    playerTotal += points;
    System.out.println("you earned " + points + " this round");
}
System.out.println("You have a total of " + playerTotal);