public class Main extends JavaPlugin {

    public void onEnable() {
        Bukkit.getPluginManger().registerEvents(new Join(this),this);
    }

}