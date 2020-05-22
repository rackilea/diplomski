public void printBoard(){

System.out.print("  ");//beginning 2 spaces
for(int i = 0; i < board.length; ++i)
   System.out.print(" " + (char)(i + 'A') +" ");//print letters seperately.

for(int i = 0; i < board.length; i++){
    for(int j = 0; j < board.length; j++){
        board[i][j] = '-';  
    }
}

for(int i = 0; i < board.length; i++){
    System.out.println();
    for(int j = 0; j < board.length; j++){
        if(j == 0){
            System.out.print(i + 1);
            System.out.print("| ");
        }
        System.out.print(board[i][j] + " | ");  
    }
}
}