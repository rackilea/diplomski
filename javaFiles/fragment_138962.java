int row=5;
int col=7;
int [][] OriginalArray = new int [row][col];

int a=0,b=0;
outerLoop:
for ( int i = 0; i < row; ++i ) {
    for ( int j = 0; j < col; ++j ){
        if( OriginalArray[i][j] == 8  ) {
            // Found the correct i,j - print them or return them or whatever
            System.out.println("{"+i+","+j+"}");
            System.out.println();
            a=i;
            b=j;
            break outerLoop;
        } 
    }
}