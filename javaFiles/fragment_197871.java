import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Util {

    private static Main plugin;

    public static void initialize(Main instance) {
        plugin = instance;
    }

    public static void toggleAFK(Player player, boolean isAFK) {
        if (plugin == null) {
            throw new IllegalStateException("This class has not been initialized yet!");
        }
        plugin.getConfig().set("AFK." + player.getUniqueId(), isAFK);
        plugin.saveConfig();

        String message = ChatColor.DARK_PURPLE + player.getName();
        message += (isAFK) ? " is now AFK." : " is no longer AFK.";
        Bukkit.broadcastMessage(message);
    }

}