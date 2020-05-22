public static void main(String args[]) {
    Die firstDie = new Die();
    int[] playerOneResults = null;

    firstDie.roll();
    System.out.println(firstDie.getFaceValue());

    Scanner userInput = new Scanner(System.in);
    System.out.println("PLease enter the name of player one");
    String playerOneName = userInput.next();

    System.out.println("Please enter the name of player two");
    String playerTwoName = userInput.next();

    System.out.println("Enter the number of dice to be thrown");
    int numDice = userInput.nextInt();

    System.out.println("First player's name: " + playerOneName);
    System.out.println("Second player's name: " + playerTwoName);
    System.out.println("Number of dice will be thrown: " + numDice);

    playerOneResults = new int[numDice];

    for (int counter = 0; counter != numDice; counter++) {
        firstDie.roll();
        playerOneResults[counter] = firstDie.getFaceValue();
        System.out.println("Player one results: " + playerOneResults[counter]);
    }

    Arrays.sort(playerOneResults);
    int position=0;
    while(position<0){
        int c = Arrays.binarySearch(playerOneResults, position,playerOneResults.length-1, 1);
        position=c;
        System.out.println(c);
    }


}