public static void highLow()
{
    Random randomGenerator = new Random();
    int num = randomGenerator.nextInt(100);
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    int numGuess = 0;

    while(loop)
    {
        System.out.print("Please enter a number: ");
        numGuess  = scanner.nextInt();
        if (numGuess > num) {
            System.out.println("Guess lower!");
            numGuess  = scanner.nextInt();
        } else if (numGuess < num) {
            System.out.println("Guess higher!");
            numGuess  = scanner.nextInt();
        } else if (numGuess == num) {
            System.out.println("Correct! You win!!!");
            loop = false;
        }
    }
}