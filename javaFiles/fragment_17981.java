int SIZE = 100;
int MID = SIZE/2;
char a[][] = new char[SIZE][SIZE];
for(char[] col : a){
    Arrays.fill(col, 'A');
}
for(int i=0; i<SIZE; i++){
    if(i == MID) System.out.println();
    for(int j=0; j<SIZE; j++){
        if(j == MID) System.out.print("  ");
        System.out.print(a[i][j]);
    }
    System.out.println();
}