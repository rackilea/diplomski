HashMap<String, Player> mp = new HashMap<String, Player>();
    for(int i = 0; i < playersCount; i++){
           Player player = new Player(arraylist.get(i));
           mp.put(arraylist.get(i), player);
    }


    // ... 

    Player p = mp.get("John");

    // now use the player John i.e. the p object