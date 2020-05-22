@EventHandler
public void playerQuit(PlayerQuitEvent e){
    String uuid = e.getPlayer().getUniqueId().toString(); // get the user's UUID
    long time = System.currentTimeMillis() / 1000; // get the current number of seconds
    plugin.getConfig().set(uuid, time); // set the UUID in the config to the current # of seconds
}