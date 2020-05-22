public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter numbers: ");
    int[] array = new int[2];
    int counter = 0;

    for (int i = 0; i < array.length; i++) {
        array[i] = input.nextInt();

        if(array[i] != 0) {
            counter++;
        }
    }

    System.out.println("This array has " + counter + " numbers.");
}