boolean okey = true;
for(int i=0; i<27; i++) {
    int [] counter = new int[10];
    for(int j=0; i<10; i++)
        counter[i]=0;
    for(int j=0; j<9; j++)
        counter[ sudoku[table[i][j].x][table[i][j].y] ] ++;
    boolean ok = true;
    for(int j=0; j<9; j++)
        if(counter[j+1]!=1)
            ok = false;
    if(!ok)
        okey = false;
}