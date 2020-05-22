public int[][] numRowCol() {
    int array[] = new int[2];

    try {
        for (int i = 0; i <= 1; i++) {
            System.out.printf("Enter a number between (2-15): %n");
            array[i] = keyboard.nextInt();
        }
        System.out.println(array[0]);
        System.out.println(array[1]);
    } catch (java.util.InputMismatchException mismatchException) {
        System.out.printf("That created an exception, the message is %s%n", mismatchException.getMessage());
    } catch (Exception err) {
        System.out.println("Another error occurred.");
        err.printStackTrace();
    }
    int arrayArray[][] = new int[array[0]][array[0]];
    return arrayArray;
}