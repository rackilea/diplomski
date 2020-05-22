public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String input;

    // Prompt user for stuff

    System.out.print ("Enter some stuff: ");

    // input stuff
    input = in.next();

    //determine and read type echo to use
    try {
        int v = Integer.parseInt(input);
        System.out.print ("You have entered an integer: " + input);
    } catch (NumberFormatException nfe1) {
        try {
            double v = Double.parseDouble(input);
            System.out.print ("You have entered a double: " + input);
        } catch (NumberFormatException nfe2) {
            System.out.print ("You have entered a string: " + input);
        }
    }
}