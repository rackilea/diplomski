public static int display2DArray(int[][] a2) {
    for (int row = 0; row < 3; row++){
        for (int column = 0; column < 4; column++){
            System.out.print(a2[row][column] + " "); // better display
        }
        System.out.println(); // better display
    }
    return 0;
}