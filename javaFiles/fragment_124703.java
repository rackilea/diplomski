public static void main(String... args) {
    int low = 1;
    int max = 10;

    Random random = new Random();
    int randomNumber = random.nextInt(max - low + 1) + low;
    int guessCount = 1;
    int userNumber;

    Scanner scanner = new Scanner(System.in);
    do {
        System.out.println("Enter your guess number = ");
        userNumber = scanner.nextInt();
        if (userNumber > randomNumber) {
            guessCount++;
            System.out.println("Too high, try again.");
        }
        else if (userNumber < randomNumber) {
            guessCount++;
            System.out.println("Too low, guess again.");
        }

        else if (userNumber == randomNumber) {
            System.out.println("It took you " + guessCount + " times of guesses.");
        }
    } while (userNumber != randomNumber);

}