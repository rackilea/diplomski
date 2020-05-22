public static void main(String[] args) {
    // Declarations
    Scanner input = new Scanner(System.in);

    System.out.print("Enter three values: ");
    int num1 = input.nextInt();
    int num2 = input.nextInt();
    int num3 = input.nextInt();
    displaySortedNumbers(num1, num2, num3);
}