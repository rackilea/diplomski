@Override
public void onEnable(){
    //plugin enabled
    this.getServer().getPluginManager().registerEvents(this, this);
}

@Override
public void onDisable(){
    //plugin disabled
}

@EventHandler   
public void onPlayerMove(PlayerMoveEvent event){ //NEVER make events with the private modifier
    Player player = event.getPlayer();
    Location location = loc.get(player.getName()); //I really don't know what your trying to do here
    //if your trying to create a new location, check out the code above
    if(player.getLocation().distance(location) >= 65) {
        player.sendMessage(ChatColor.AQUA + "Out of reach.");
    }
}