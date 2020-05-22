HashMap<String, PlayerInfo> allplayers = new HashMap<String, PlayerInfo>();


public PlayerInfo getPlayer(Player player){
  if(allplayers.containsKey(player.getName())){
     return allplayers.get(player.getName());
  }else{
     return null;
  }
}