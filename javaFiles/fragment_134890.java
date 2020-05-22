package is.bamboo0w.mad.yet;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class mad extends JavaPlugin {

@Override
public void onEnable() {
    PluginDescriptionFile pdfFile = getDescription();
    Logger logger = getLogger();

    logger.info(pdfFile.getName() + " has been Enabled! (V." + pdfFile.getVersion() + ")");
}

@Override
public void onDisable() {
    PluginDescriptionFile pdfFile = getDescription();
    Logger logger = getLogger();

    logger.info(pdfFile.getName() + " has been Disabled! (V." + pdfFile.getVersion() + ")");
}


public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player)) {
        sender.sendMessage("You must be a player to use this command");
        return false;
    }
    int score = 0;
    score++;
    Player player = (Player) sender;
    if (score <= 1) {
        player.sendMessage(ChatColor.AQUA + "Gimme A Kiss, " + player.getName() + "!");
    } else if (score <= 2) {
        player.sendMessage(ChatColor.AQUA + "Want Some Burick, " + player.getName() + "!");
    } else if (score <= 3) {
        player.sendMessage(ChatColor.AQUA + "Stop Scamming, " + player.getName() + "!");
    } else if (score <= 4) {
        player.sendMessage(ChatColor.AQUA + "Are You Duping There " + player.getName() + "!");
    } else if (score <= 5) {
        player.sendMessage(ChatColor.AQUA + "I'm Watching You, " + player.getName() + "!");
    } else if (score <= 6) {
        player.sendMessage(ChatColor.AQUA + "Coming For You, " + player.getName() + "!");
    } else if (score <= 7) {
        player.sendMessage(ChatColor.AQUA + "I'm Gonna PK You, " + player.getName() + "!");
    } else if (score <= 8) {
        player.sendMessage(ChatColor.AQUA + "Your Gonna Get Banned, " + player.getName() + "!");
    } else {
        score = 0;
    }
    return true;
}