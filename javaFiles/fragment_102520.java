public char checkWinner()
{    
   for (int i=0; i < GRIDSIZE; i++) {
       if (checkRow(i)) return winner;
       if (checkColumn(i)) return winner;    
   }

   if (checkDiagTopLeft()) return winner;
   if (checkDiagBottomLeft()) return winner;
}