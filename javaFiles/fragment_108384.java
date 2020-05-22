public static void printCross(int size, char display)
{
    for (int row = 0; row < size; row++) {
        for (int col = 0; col < size; col++) {
            if (row == col || row + col == size - 1) {
                System.out.print(display);
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}