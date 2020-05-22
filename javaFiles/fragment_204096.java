@EventHandler
public void disableMeCommand(PlayerCommandPreprocessEvent event) {
    Player p = event.getPlayer();
    if(!p.hasPermission("ste999.me")) {
        if(event.getMessage().startsWith("/me")) {
            event.setCancelled(true);
            p.sendMessage("§4Dont me me!");
        }
    }
}