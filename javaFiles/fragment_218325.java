public static void main(String[] args) {
    //Display welcome message 
    System.out.println("Welcome to the Math Functions event!");
    Scanner keyIn = new Scanner(System.in);
    Scanner userInput;
    System.out.print("Press the ENTER key to toss the dice.");
    keyIn.nextLine();


    int tries = 0;

    int sum = 0;
    while (sum != 7 && sum != 11) {
    // Here is where you call your newly created method
    int roll1 = rollDice();
    int roll2 = rollDice();
    sum = roll1 + roll2;
    System.out.println(roll1 + " + " + roll2 + " = " + sum);
    tries++;
    }
}