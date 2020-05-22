System.out.println("Do you want to play again? (Y/N) ");
answer = input.next();
while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
    System.out.println("That is not valid input. Please enter again");
    answer = input.next();
}

if (answer.equalsIgnoreCase("n"))
    keepPlaying = false;