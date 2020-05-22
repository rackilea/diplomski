public static int input() {
    System.out.println("Please enter amount of change under 100 cents: ");
    Scanner input = new Scanner(System.in);
    int change = input.nextInt();
    if (change % 5 < 2) {
        change = change + (change % 5);
    } else if (change % 5 > 2) {
        change = change - (change % 5);
    }
    return change;

}

public static int[] maxQuarters(int input) {

    int quarters = input / 25;
    int leftover = input - 25*quarters;
    return new int[]{quarters, leftover};
}

public static int[] maxDimes(int input) {
    int first[] = maxQuarters(input);
    int change = first[1];
    int dimes = change / 10;
    int leftover = change - 10*dimes;
    return new int[]{dimes, leftover};
}

public static int maxNickels(int input) {
    int second[] = maxDimes(input);
    int change = second[1];
    int nickels = change / 5;
    return nickels;
}

public static void makeChange(int input) {
    int first[] = maxQuarters(input);
    int quarters = first[0];
    int second[] = maxDimes(input);
    int dimes = second[0];
    int nickels = maxNickels(input);
    System.out.println("The minimum number of coins you could use is: " + quarters + " quarters, " + dimes + " dimes and " + nickels + " nickels");

}

public static void main(String[] args) {
    int input = input();
    makeChange(input);
}