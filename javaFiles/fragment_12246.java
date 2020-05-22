public static void main (String[] args)
{
    Scanner in = new Scanner(System.in);
    String[][] matrix = new String[7][7];

    /* Set Values */
    for(int i = 0; i < 7; i++) {
        matrix[i] = in.nextLine().split(",");
    }

    /* Print Function */
    for(int i = 1; i < 7; i++) {
        for(int j = 1; j < 7; j++) {
            System.out.println(matrix[i][0] + " " + matrix[0][j] + " " + matrix[i][j]);
        }
        System.out.println();
    }
}