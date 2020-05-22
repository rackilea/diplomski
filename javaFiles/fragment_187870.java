private static void printString2DArray(String[][] in)
{
    for (int i = 0; i < in.length; i++) {
        for (int j = 0; j < in[i].length; j++) {
            if (i != 0 && j == 0) {  // This is just formatting (you may want to change it)
                System.out.print(", ");
            }
            System.out.print(in[i][j]);
        }
    }
}