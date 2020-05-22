public static void main(String[] args) {
    Scanner k = new Scanner(System.in);
    String userInput;
    char msb;
    int convertedBinary;
    String removedMSB;
    ArrayList<String> binaryInput = new ArrayList<String>();
    System.out.println("Press 1 to use the Binary Converter: Press 2 to use the Decimal Converter:");
    int userChoice = k.nextInt();

    if (userChoice == 1) {
        System.out.println("Welcome to the Binary Converter!");
        System.out.println("Please enter a 10 bit binary number");
        // Adding the input to the ArrayList
        userInput = k.next();
        String withoutFirstChar = userInput .substring(1);
        msb = userInput.charAt(0);

        if (msb == '0') {
            convertedBinary = Integer.parseInt(userInput, 2);
            System.out.println("Your number in decimal is " + convertedBinary);
        } else if (msb == '1') {
            convertedBinary = Integer.parseInt(withoutFirstChar , 2);
            System.out.println("Your number in decimal is " +      convertedBinary);
        }
    }
}