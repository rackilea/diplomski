public static ArrayList<ArrayList<Integer>> deal(int[] cards) {
   ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>();
   for(int  i = 0; i < 4; i++) {
       board.add(new ArrayList<Integer>);
   }
   board.get(0).add(1);
   board.get(0).add(0);
   board.get(1).add(14);
   board.get(1).add(0);
   board.get(2).add(27);
   board.get(2).add(0);
   board.get(3).add(40);
   board.get(3).add(0);

   for (int i = 0; i < 4; i++) {
     for (int j = 0; j < 12; j++) {
         board.get(i).add(cards[j + (i * 12)]);
     }
   } 
  return board;
}