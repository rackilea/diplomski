private static boolean check_game_state(char[] board, int length) 
{ 
  bool row = false;
  for (int i = 0; i < length; ++i) {
    bool innerRow = true;
    for (int j = 0; j < length; ++j) { // calculate the ith row
      innerRow = innerRow && board[i*length+j] == cSymbol;
    }
    row = row || innerRow;
  }
  if (row) 
  { 
    // somebody won...
  } 
}