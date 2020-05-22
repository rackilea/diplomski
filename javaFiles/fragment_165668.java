public static void main( String[] args )
{
    Scanner keyboard = new Scanner(System.in);
    Random r = new Random();

    int secretNumber = 1 + r.nextInt(100);
    int guesses = 0;
    int tries = 0;

    System.out.println("I'm thinking of a number between 1-100.  You have 7        guesses.");
    while(guesses != secretNumber && tries < 7) {
        System.out.println("Guess #"+tries+": ");
        guesses = keyboard.nextInt();
        if(guesses == secretNumber) {
            System.out.println("You win");
            break;
        } else if(guesses < secretNumber) {
            System.out.println("Sorry too low");
        } else {
            System.out.println("Sorry too high");
        }
        tries++;
        if(tries >= 7) {
            System.out.println("Sorry, you didn't guess it in 7 tries.  You lose.");
        }
    }
}