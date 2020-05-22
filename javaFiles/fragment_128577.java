//By convention you always capitalize Class names.  So I changed the name from "main" to "Main".
public class Main extends JavaPlugin implements Listener {

    // I am not sure why you had a static Bukkit variable, so I removed it.

    // This variable is transient, so it can be safely accessed from other threads
    public transient List<String> swares;

    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getConfig().options().copyDefaults(true);
        saveConfig();
        this.reloadConfig();

        // I get the swears out of the config here, so I won't have to
        // access the config while in the AsyncPlayerChatEvent
        swares = getConfig().getStringList("Swears");


        // A more common way to log something is through the logger, here is an example:
        getLogger().log(Level.INFO, "Enabled!");
        // Also, a good thing to remember is the the console will not see chat colors as their code
        // So instead of displaying a message as red it would display '§4message'
    }

    public void onDisable() {
        //Here is a different way to use the logger:
        getLogger().info("Disabled!");
    }

    @EventHandler
    public void playerChat(AsyncPlayerChatEvent e) {

        // I combined this to one line, and reversed it so there are less curly braces.
        if (e.getRecipients().size() > 10)
            return;

        // I replaced what you did with this, it's much simpler!
        for (String sware : swares) {
            // adding (?i) tells it to ignore case
            e.setMessage(e.getMessage().replaceAll("(?i)" + sware, "curse"));
        }
    }
}