public static void ladders() {
  for (int i = 0 ; i < 6 ; ){    
   ladderBottoms [i] = (int) ((Math.random () * 80)+1);
   ladderTops [i] = (int) ((Math.random () * 80)+1);
      if(ladderBottom[i] <= /*do you really want =*/ ladderTop[i]){
           i++; /* this is OK so increment; else have another go*/
      }
  }//for
}//ladders