package me.flyingscot5.bam_mad_yet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

public class C_isbammadyet implements TabExecutor {

@Override
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (!(sender instanceof Player)) {
        sender.sendMessage("You must be a player to use this command");
    }
    Player player = (Player) sender;
    if (!main.scores.containsKey(player)) {
        main.scores.put(player, 0);
    }
    int score = main.scores.get(player);
    score += new Random().nextInt(3);
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
    main.scores.replace(player, score);
    return true;
}

@Override
public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
    List<String> nothing = new ArrayList<String>();
    nothing.add("");
    return nothing;
}
}