System.out.print("How many guesses would you like? (5, 10, 20)");
do {
    int numberOfGuesses = scan.nextInt();
    //on correct guess, break out of the loop
    if(numberOfGuesses == 5 || numberOfGuesses == 10 || numberOfGuesses == 20)
        break;
System.out.print("Please enter a guess having one of these values (5, 10, 20)");
} while (true);