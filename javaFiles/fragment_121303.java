int guess = 0;
int playerCount = 2;
//boolean[] won = new boolean[playerCount];
int[] numbers = new int[playerCount];

for (int i = 0; i < playerCount; i++)
    numbers[i] = rand.nextInt(101);

System.out.println("Guess a number between 0 and 100.");
while (game == false) {
    for (int player = 0; player < playerCount; players++) {
        System.out.print("Player #"+player+" guess: ");
        guess = Integer.parseInt(input.nextLine());
        //if (won[player] == false) {
            if (guess == numbers[player]) {
                //won[player] = true;
                game = true;
                System.out.println("Player #" + player + ": Correct!");
                break;
            } else if (guess < numGuess) {
                System.out.println("Player #" + player + ": Too low!");
            } else if (guess > numGuess) {
                System.out.println("Player #" + player + ": Too high!");
            }
        //}

    }

    //for (int i = 0; i < playerCount; i++)
    //  if (won[i] == true)
    //      game = true;
}