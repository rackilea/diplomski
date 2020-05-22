public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    // get temp
    System.out.print("Enter a temperature: ");
    if (in.hasNextDouble()) {
        double temp = in.nextDouble();

        // determine temp type and determine state

        System.out.print("Enter C for Celcius or F for Fahrenheit: ");
        String type = in.nextLine();
        if (type.equals("c") || type.equals("C")) {
            if (temp <= 0) {
                String state = "frozen";
            } else if (temp >= 100) {
                String state = "gaseous";
            } else {
                String state = "water";
            }
        }
        String state = null;
        if (type.equals("f") || type.equals("F")) {
            if (temp <= 32) {
                state = "frozen";
            } else if (temp >= 212) {
                state = "gaseous";
            } else {
                state = "water";
            }
        } else if ((!type.equals("c") || !type.equals("C") || !type.equals("f") || !type.equals("F"))) {
            System.out.print("Not valid input.");
            System.exit(0);

        } else {
            System.out.println("Not valid input.");
            System.exit(0);
        }

        System.out.println("The state of the water is " + state);

    }
}