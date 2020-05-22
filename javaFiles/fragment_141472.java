int[] player1Bets = new int[5];
for(int i=0;i<5;i++) {
   try {
      player1Bets[i] = Integer.parseInt(keyin.nextLine());
   }
   catch(NumberFormatException e) {
       System.out.println("Player1 took" + i + "bets. he is done betting");
   }
}
...