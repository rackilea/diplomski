private static void addition() {
    Scanner input = new Scanner(System.in);

    System.out.println("How many numbers would you like to add?");
    int amountNumbers = input.nextInt();

    int sum = IntStream.generate(input::nextInt)
                       .limit(amountNumbers)
                       .sum();

    System.out.println("Sum: " + sum);
}