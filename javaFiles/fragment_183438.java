boolean fillRemainderOfBoard(Square sender){
 if (num_defined_on_start) {
     return next.fillRemainderOfBoard(this);
 } else {
   for (i = 1; i < 9; ++i) {
     if (setting i a legal_move)
        this.setCurrentPos(i);
     else
        continue;
     if (next.fillRemainderOfBoard(this))
       return true;
   }
   return false;
}