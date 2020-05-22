public void addPlayer(Player player){
  if(!allplayers.containsKey(player.getName())){
     //Load playerInfo
     PlayerInfo p = new PlayerInfo(....);
     //put into hashmap
     allplayers.put(player.getName(), p);
  }
}

//saving PlayerInfo can be called on PlayerDisonnect/Server shutdown
 public void savePlayer(Player player){ 
    if(allplayers.containsKey(player.getName())){
      PlayerInfo p = allplayers.get(player.getName()); 
     //Save information 
      .....
     //remove player from HashMap
     allplayers.remove(player.getName());   
    }  
 } `