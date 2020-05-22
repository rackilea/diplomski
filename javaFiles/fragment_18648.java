public static int setHalfMoves(int s, int e){
     return (
             //mask for e to only the correct bits
             (e & 0x7f)
             //left shifted into position
             << 6)
             //zero out the original value
             | (s & (~(0x7f << 6)));
}
public static void main (String[] args){
   int s = BoardState.new_state(36, 84, 1, 0);
   System.out.println("ep square: " + epSquare(s)); //36
   System.out.println("half moves: " + halfMoves(s)); //84
   //Note that this is fixed to now reassign s
   s = setHalfMoves(s, 13);
   System.out.println("half moves: " + halfMoves(s)); //should give 13
}