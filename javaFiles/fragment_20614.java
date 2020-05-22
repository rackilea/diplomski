public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

    HashSet<Integer> hs = new HashSet<>();
    int GuessLogic = (int) (Math.random() * 10 + 1);

    int guess;
    int NumGuess = 0;
    do {
        System.out.print("Enter a guess: ");
        guess = keyboard.nextInt();
        NumGuess++;

        if (hs.contains(guess)) {
            System.out.println("You have already entered this number");
            continue; // this will repeat the loop
        }

        if (guess < 0 || guess > 10) {
            System.out.println("Your guess is out of the specified range. Please try again.");
            continue; // this will repeat the loop
        }

        System.out.println("Your guess is " + guess);
        if (guess == GuessLogic) {
            System.out.println("You got it right!! Congrats!! Total Number of Guesses: " + NumGuess);
            return; // this will stop the method
        }
        else if (guess < GuessLogic) {
            System.out.println("You are wrong!!! Hint: Guess Higher, Guess number: " + NumGuess);
        }
        else if (guess > GuessLogic) {
            System.out.println("You are wrong!!! Hint: Guess Lower, Guess number: " + NumGuess);
        }

        hs.add(guess);

    } while (true);

}