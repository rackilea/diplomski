public class PlayerInteract implements Listener {

    // priority is when the listener is called.
    // LOWEST is called first, then LOW, NORMAL, HIGH, HIGHEST, MONITOR.
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerInteract(PlayerInteractEvent event) {
        // ...
    }

}