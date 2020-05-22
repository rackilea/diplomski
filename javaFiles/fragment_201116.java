for(char i = board[r][c] ; c<3 ; r++) {
    ...
    if(r == 2)  {
        r=0;
        c++;
    }
 }