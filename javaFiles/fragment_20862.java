public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        String input = userInput.next();
        if (input == null) {
            printError();
            userInput.close();
            return;
        }

        try {
            int i = Integer.parseInt(input);
            if (i % 2 == 0) {
                System.out.println("even");
            }

            else if (i % 2 != 0) {
                System.out.println("odd");
            }
        } catch (NumberFormatException e) {
            printError();
        }

        userInput.close();

    }

    private static void printError() {
        System.out.println("Please enter a number.");
    }