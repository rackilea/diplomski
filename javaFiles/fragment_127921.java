int numToReplace = 72;
int replacement = 21;
//loop through each nested array
for ( int i = 0; i < board.length; i++ ) { 
   //loop through each element of the nested array 
   for ( int j = 0; j < board[i].length; j++ ) { 
      if ( board[i][j] == numToReplace ) {
         board[i][j] = replacement;
      }
   }
}