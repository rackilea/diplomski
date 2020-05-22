public static int getInput(int min, int max) {
    for (;;) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(String.format("Answers must be between %s and %s", min, max));
        try {
            int value = scanner.nextInt();
            if (min <= value && value <= max) {
                return value;
            } else {
                System.out.println("Please enter a valid value");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input was no number");
        }
    }
}