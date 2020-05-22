public class Join implements Listener {

    private Main plugin;

    public Join(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent ev) {
        ev.setJoinMessage("Just another test");
    }
}