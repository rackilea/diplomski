public static void main(String[] args) {
        System.out.println("Guess a word or character");
        Scanner keyboard = new Scanner(System.in);
        String input;
        input = keyboard.nextLine();

        char c = input.charAt(0);

        if (input.equalsIgnoreCase("candy") || c == 'C') {
            System.out.println("You guessed correctly.");
        } else {
            System.out.println("Try again...");
        }
    }