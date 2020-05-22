Collections.sort(playerList, new Comparator<String[]>(){
   @Override
   public int compare(String[] player1, String[] player2) {
         return Integer.parseInt(player1[1]) - Integer.parseInt(player2[1]);
     }
 }