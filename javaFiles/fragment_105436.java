public static void main(String[] args) {
    System.out.print("Hexadecimal Input:");
    // read the hexadecimal input from the console
    Scanner s = new Scanner(System.in);
    String inputHex = s.nextLine();
    String str = inputHex;

    try {
        for (int i = 0; i < str.length() - 1; i+=2) {
            inputHex = str.substring(i, i + 2);

            // actual conversion of hex to decimal
            Integer outputDecimal = Integer.parseInt(inputHex, 16);
            System.out.println("Decimal Equivalent : " + outputDecimal);
        }

    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        // Printing a warning message if the input is not a valid hex number
        System.out.println("Invalid Input");

    }

    finally {
        s.close();

    }

}