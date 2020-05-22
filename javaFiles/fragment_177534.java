public static void main(String[] args) {

    Scanner kb = new Scanner(System.in);
    System.out.println("Please enter row size");
    int row = kb.nextInt();
    System.out.println("Please enter column size");
    int column = kb.nextInt();

    int[][] Array = new int[row][column];

    System.out.println();
    for (int r = 0; r < Array.length; r++) {
        for (int c = 0; c < Array[r].length; c++) {
            Array[r][c] = (int) (Math.random() * 99 + 1);
            System.out.print(Array[r][c] + " ");
        }
        System.out.println();
        System.out.println();
    }

    int find;
    do {
        System.out.println("Please input a number to look for or enter \"-1\" to stop ");
        find = kb.nextInt();

        if (find != -1) {

            int[] coordinates = findValue(Array, find);

            if (coordinates[0] == -1 && coordinates[1] == -1) {
                System.out.println("The number could not be found");                    
            } else {
                System.out.println("The number is located in the " + (coordinates[0]) + " row, and the " + (coordinates[1]) + " column");
            }
        }

    } while (find != -1);
}

public static int[] findValue(int[][] Array, int find) {

    int[] coordinates = new int[2];

    coordinates[0] = -1;
    coordinates[1] = -1;

    for (int x = 0; x < Array.length; x++) {
        for (int y = 0; y < Array[x].length; y++) {
            if (Array[x][y] == find) {

                coordinates[0] = x + 1;
                coordinates[1] = y + 1;

                break;
            }
        }
    }

    return coordinates;
}