private static int readNumber(Scanner in) {
    System.out.print("Please enter a digit: ");
    int digit = in.nextInt();
    in.nextLine(); // you must clear the newline char from the buffer
    return digit;
}