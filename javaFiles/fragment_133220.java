public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int digit = 10; // initialize with "bad" input
    while (digit > 9) {
         digit = readNumber(in);
    }
    System.out.println("Correct! " + digit + " is an integer!");
}

private static int readNumber(Scanner in) {
    System.out.print("Please enter a digit: ");
    int digit = in.nextInt();
    in.nextLine(); // you must clear the newline char from the buffer
    return digit;
}