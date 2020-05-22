int numberDrawn = drawNumber();
// Initial value which ensures that loop is entered
int number = -1;

while (number != numberDrawn) {
    // Let the user guess a number
    System.out.println("Guess a number!");
    number = Integer.parseInt(reader.nextLine());

    // Check the number
    if(number < numberDrawn) {
        System.out.println("The number is greater");
    } else if (number > numberDrawn) {
        System.out.println("The number is lesser");
    } else {
        System.out.println("Congratulations, your guess is correct!");
    }
}