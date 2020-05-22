int a[][] ={{0, 1, 2, 0, 2},
             {4, 4, 4, 4, 4},
             {0, -1, 8, 10, -1},
             {0, 3, -1, 2, 1},
             {4, 8, 4, 8, 12},
             {-1, -1, 2, 0, 1},
             {1, 8, 2, 4, -1},
             {8, 16, -1, 4, 0}};
int count = 0;          
for (i=0; i<8; i++) {
    int numbersOfMinus1 = 0;
    for (j=0; j<5; j++) {
        if (a[i][j] == -1){
            numbersOfMinus1++;
        }      
    }
    if (numbersOfMinus1>=2){
         count++;
    }
}

System.out.println("results: " + count);