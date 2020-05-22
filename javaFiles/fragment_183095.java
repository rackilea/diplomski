Scanner input = new Scanner(System.in);
String more = "N";
do {
    System.out.println("Welcome to Game Guru!");

    int number = 1 + (int) (Math.random() * 20);
    int guess = 0;

    do {
        try {
            System.out.println("Guess my magic number [1-20]: ");
            String text = input.nextLine();
            guess = Integer.parseInt(text);
            if (guess > 20 || guess < 1) {
                System.out.println("Number out of range");
            } else if (guess < number) {
                System.out.println("Number too small");
            } else if (guess > number) {
                System.out.println("Number too large");
            }
        } catch (NumberFormatException e) {
            System.out.println("Should enter an integer");
        }
    } while (guess != number);

    System.out.println("You got it!");
    System.out.println("Want more games? Please enter Y or N.");
    more = input.nextLine();

} while (more.equalsIgnoreCase("y"));