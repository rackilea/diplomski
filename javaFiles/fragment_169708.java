public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter numbers: ");
    int[] array = new int[100];
    int i = 0;

    for (; i < array.length; i++) {
        int inputValue = input.nextInt();

        if(inputValue <= 0) {
            break;
        } else {
            array[i] = inputValue;
        }
    }

    System.out.println("This array has " + i + " numbers.");
}