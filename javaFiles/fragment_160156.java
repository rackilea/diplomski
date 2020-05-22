@EventHandler
public void onInteract(PlayerInteractEvent e) {
    //Event called when a player interacts with something, AKA right click or left click
    Player player = e.getPlayer();
    ItemStack hand = player.getItemInHand();
    if(/**Hand is honey**/) //DOSOMETHING
}