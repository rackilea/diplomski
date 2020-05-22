private static void addition() {
    Scanner input = new Scanner(System.in);

    System.out.println("How many numbers would you like to add?");
    int amountNumbers = input.nextInt();

    int sum = 0;
    for (int counter = 0; counter < amountNumbers; counter++) {
        sum += input.nextInt();
    }

    System.out.println("Sum: " + sum);
}