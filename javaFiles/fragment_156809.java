public static void printArray(String a [][]) {

    for(int col=0; col < a[0].length; col++) {
        for (int row = 0; row < a.length; row++) {
            if (row!=a.length-1) {
                System.out.print(a[row][col] + "|");
            }
            else {
                System.out.print(a[row][col]);
            }
        }
        System.out.println();
    }
}