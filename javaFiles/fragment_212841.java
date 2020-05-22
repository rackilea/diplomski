public static int tulosta_matriisi(int[][] matriisi) {
    int i = 0, j = 0;
    for (i = 0; i < matriisi.length; i++) {
        for (j = 0; j < matriisi[i].length; j++) {
            if (j == matriisi[i].length - 1 && i <= matriisi.length) {
                System.out.println(matriisi[i][j]);
            } else if (i <= matriisi.length && j <= matriisi[i].length) {
                System.out.print(matriisi[i][j] + "\t");
            }
        }
    }
    return matriisi[i - 1][j - 1];
}