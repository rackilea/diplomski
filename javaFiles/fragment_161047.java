@EventHandler
public void playerMovesSoCancelsTask(PlayerMoveEvent e) {
    Player player = e.getPlayer();//Get the player

    //Check if the player is moving to a new block
    if (e.getTo().getBlockX() != e.getFrom().getBlockX() || e.getTo().getBlockY() != e.getFrom().getBlockY() || e.getTo().getBlockZ() != e.getFrom().getBlockZ()) {

        //Check if the player is waiting to turn on/off pvp
        if (PVP.playersWaiting.contains(player.getName())) {
            player.sendMessage(ChatColor.RED + "You moved so the action was cancelled!");
            PVP.playersWaiting.remove(player.getName()); //Remove the player from the waiting list
        }
    }
}