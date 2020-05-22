for (int j = 0; j < size; j++) {
   if( board[number][j] == 'K') {
      ++counter;
   }
}
System.out.println("You've found " + counter + " keys!");