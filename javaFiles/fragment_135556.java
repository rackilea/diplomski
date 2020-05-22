public static void main(String args[]) throws Exception {
        System.out.print("Enter Your favorite number:");
        Scanner scanner = new Scanner(System.in);
        String numin = scanner.next();
        try {
            int intg = Integer.parseInt(numin);
            System.out.print("Your favorite number is: " + intg);
        } catch (NumberFormatException nfe) {
            System.out.print(numin + " is not a valid argument please restart");
        }
    }