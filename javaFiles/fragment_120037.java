final Scanner kb = new Scanner(System.in);
Integer temp = null;

while (temp == null) {
    System.out.println("Enter a number between 2 and 10.");
    final String input = kb.nextLine();
    try {
        final Integer value = Integer.valueOf(input);
        if (value >= 2 && value < 10) {
            temp = value;
        } else {
            System.out.println("Bad number, try again");
        }
    } catch (NumberFormatException ex) {
        System.out.println("Not a number, try again");
    }
}
int n = temp;