@EventHandler
public void onDisallowPvpEvent(DisallowedPVPEvent event) {
    if(//condition) {
        event.setCancelled(true);
    }
}