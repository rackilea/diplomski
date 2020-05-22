HashMap<String, String> map;

    for(Player player : team1.getPlayers()){
        map = new HashMap<String, String>();
        map.put("player", player.getName()); 
        map.put("score", "0");
        mylist.add(map);
     }