//Some Listener class
...
private YourPlugin plugin; //example
...
@EventHandler
public void playerDeath(PlayerDeathEvent event) {
    if(plugin.isEventMode()) {  //TODO when event mode is on }
}