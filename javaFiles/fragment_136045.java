Player currentPlayer;
ArrayList<Player> players = new ArrayList<Player>();
// a lot of your code
while (tdIter.hasNext()) {  
    System.out.println("============================");
    Element tdEl = tdIter.next();
    currentPlayer = new Player();
    // instead of that:
    //String name = tdEl.getElementsByClass("playertablePlayerName").text();
    // do that:
    currentPlayer.mName = tdEl.getElementsByClass("playertablePlayerName").text();
    // the same with the rest of the gathered information
    // at the last line in this while loop
    players.add(currentPlayer);
}