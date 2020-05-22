String[][] board = [a,b,c,d]
                   [e,f,g,h];   

// i - for each row
for(int i=0; i<board.length; i++){

    // j - start from this column in a row
    for(int j=0; j<board[i].length; j++){
        String temp = "";        
        // put all columns right to the j and including together
        for(int k=j;k<board[i].length; k++) {
            temp = temp+board[i][k];
            System.out.println(temp);
        }
    }
}