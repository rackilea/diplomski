public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int value = -1;
    do {
        System.out.print("Input: ");
        String input = scanner.next();
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Error, try again: " + input);
        }
    } while (value < 1);
    System.out.println(value + " is a positive integer.");
}