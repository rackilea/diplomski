@EventHandler(priority = EventPriority.MONITOR)
public void onCommand(PlayerCommandPreprocessEvent event) {
    String label = event.getMessage();
    String[] components = label.split(" ");
    if (components[0].equalsIgnoreCase("/tp")) {
        Player sender = event.getPlayer();
        // Here you go
    }
}