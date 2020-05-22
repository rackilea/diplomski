@EventHandler
public void inventoryClose(InventoryCloseEvent e){
  //check if the inventory is the duel inventory
  if(e.getInventory().getName().equals(ChatColor.DARK_RED + "[" + ChatColor.DARK_GREEN + "DuelRequest" + ChatColor.DARK_RED + "]"){
    //get the player who opened the inventory
    Player p = (Player) e.getWhoClicked();

    //now, check if the selecting HashMap contains the Player above
    if(selecting.containsKey(p.getUniqueId())){
      //get the target of the duel
      Player target = Bukkit.getPlayer(selecting.get(p.getUniqueId()));

      //open the kit selector for the target Player above
      openKitSelector(target);

      //now, remove the target's, and the sender's UUID from the selecting
      //HashMap, to make sure that we don't accidentally open the kit
      //selector for a player who is currently in a duel.
      selecting.remove(p.getUniqueId());

      //make sure the selecting HashMap contains the target's UUID before
      //attempting to remove it
      if(selecting.containsKey(target.getUniqueId())){
        selecting.remove(target.getUniqueId());
      }
    }
  }
}