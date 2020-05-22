public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner userinput = new Scanner(System.in);

    System.out.println("Enter a binary number (only 1's or 0's): ");
    String binary_number = userinput.next();

    if(!binary_number.matches("[01]+")) {
        System.err.println("\nPlease enter a valid binary number");
    } else {
        int value = 0;
        for (int i = 0; i < binary_number.length(); i++) {
            if (binary_number.charAt(i) == '1') {
                int exponent = binary_number.length() - 1 - i;
                value += (int) Math.pow(2, exponent);
            } 
        }
        System.out.print(binary_number + " == " + value);
    }
}