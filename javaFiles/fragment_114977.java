Scanner scan = new Scanner(System.in);

 for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println("Enter " + i + " column matrice...\nEnter" + j + " row matrice...");

            a[i][j] = scan.nextInt();

        }

    }
    System.out.println("Final matrix\n");
    printMatrix(a, m, n);
}

static void printMatrix(int[][] a, int m, int n) {
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            System.out.print(a[i][j]);

        }
        System.out.println();

    }

}

 static void sortMatriceColumn(int[][] a, int rowNum, int colNum) 
   {
    //int temp;
    int i,j = 0,k;

    for ( i = 0; i < colNum; i++) {
        for ( j = 0; j < rowNum; j++) {
            for ( k = j + 1 ; k < rowNum; k++) {
                if(i%2==0){
                if (a[j][i] > a[k][i]) {
                    int temp1= a[j][i]; 
                    a[j][i]=a[k][i];
                    a[k][i]=temp1;
                }
                }else{
                    if (a[j][i] < a[k][i]) {
                        int temp1= a[j][i]; 
                        a[j][i]=a[k][i];
                        a[k][i]=temp1;
                    }
                }
            }
        }
    }
    for(int r=0;r<colNum;r++){
        for(int m = 0; m < rowNum ; m++) {
            System.out.print(" " + a[r][m]);
            }
        System.out.println();
    }
  }