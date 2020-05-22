public static void main (String[] args)
{
    int[][] ejcedula = {{1,0,1,2},{0,0,1,2},{2,3,4,0}};
    char[][] matrixej = new char[ejcedula.length][4];
    matrixej = consolaej(ejcedula,matrixej);

    /* Print Matrixej */
    for (int i = 0; i < ejcedula.length; i++) {
        for(int j = 0; j < 4; j++) {
            System.out.print(" " + matrixej[i][j]);
        }
        System.out.println();
    }
}

public static char[][] consolaej(int[][] ejcedula, char[][] matrixej) {
    for (int i = 0; i < ejcedula.length; i++) {
        for(int j = 0; j < 4; j++) {
            if(ejcedula[i][j] != 0) {
                matrixej[i][j] = 'x';
            }
        }
    }
    return matrixej;   
}