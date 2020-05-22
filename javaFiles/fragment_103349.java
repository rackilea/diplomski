import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
//import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

public class Main extends JavaPlugin implements Listener{
    public static boolean chatMuted = false;
    @Override
    public void onEnable()
    {
        getLogger().info("events tester enabled!");
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(this, (this));
    }

    @Override
    public void onDisable()
    {
        getLogger().info("events tester disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player player = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("mutechat")) {
            if (player.hasPermission("ste999.chat.mute")) {
            if(chatMuted == false) {
                Bukkit.broadcastMessage("§aThe chat has been disabled!");
                chatMuted = true;
                }
                else {
                if(chatMuted == true) {
                Bukkit.broadcastMessage("§aThe chat has been enabled!");
                chatMuted = false;
                }
                }
            } else {
                if (!player.hasPermission("ste999.chat.mute")) {
                player.sendMessage("§4You can't mute the chat silly!");
                }
            }
            }
    return false;
    }
    @EventHandler
    public void OnChat(AsyncPlayerChatEvent event)
    {
        Player pli = event.getPlayer();
        if (chatMuted == true) {
            if (!pli.hasPermission("ste999.chat.bypass")) {
                event.setCancelled(true);
                pli.sendMessage("§4The chat has been disabled");
            } else {
                if (pli.hasPermission("ste999.chat.bypass")) {
                    event.setCancelled(false);
                }
            }
        }
    }
}