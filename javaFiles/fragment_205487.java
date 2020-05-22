public static void main(String[] args) {

    welcome();

    int total = 0;
    while (total < 21) {
        total += rollingDice();
    };
    System.out.println("Total for all rolls was: " + total);

    if (total == 21) {
        System.out.println("You win!");
    }
    else {
        System.out.println("You lose.");
    }

}

public static void welcome() {
    System.out.println("Welcome to the game of Twenty-One! FEELING LUCKY?! goodluck!");

}

public static int rollingDice() {

    int dice1 = (int) (Math.random() * 6 + 1);
    int dice2 = (int) (Math.random() * 6 + 1);
    int sum = dice1 + dice2;

    System.out.println(String.format("dice1: %d dice2: %d for a total: %d", dice1, dice2, sum ));

    return sum;

}