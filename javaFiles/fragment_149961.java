private static void addition() {
    Scanner input = new Scanner(System.in);

    System.out.println("How many numbers would you like to add?");
    int[] numbers = new int[input.nextInt()];

    for (int index = 0; index < numbers.length; index++) {
        numbers[index] = input.nextInt();
    }

    int sum = 0;
    for (int index = 0; index < numbers.length; index++) {
        sum += numbers[index];
    }

    System.out.println("Sum: " + sum);
}