public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter numbers: ");
    int[] array = new int[100];
    int i = 0;

    while (input.hasNextInt()) {
        int inputValue = input.nextInt();

        array[i++] = inputValue;
    }

    System.out.println("This array has " + i + " numbers.");
}