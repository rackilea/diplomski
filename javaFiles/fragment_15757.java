public static ArrayList<Player> waitingForAmountPlayers = new ArrayList<>();

public void onChat(AsyncPlayerChatEvent e) {

 Player p = e.getPlayer();

 if (waitingForAmountPlayers.indexOf(p) != -1) {

  //
  // YOUR CODE
  //

  waitingForAmountPlayers.remove(p);

 }

}