public static void main(String args[]) throws IOException {

    Scanner infile = new Scanner(new File("RAMerrors.txt"));
    String result;
    Double decimal;

    while (infile.hasNextLine()) {
        String line = infile.nextLine();
        Scanner input = new Scanner(line);
        String hex = input.next();
        result = hexToBinary(hex);
        System.out.println("Binary of " + hex + ":" + result);
        decimal = binaryToDecimal(result);
        System.out.println("Decimal value: " + decimal);            
    }