package me.flyingscot5.bam_mad_yet;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class L_PlayerQuit implements Listener {
public L_PlayerQuit(main main) {
    plugin = main;
    plugin.getServer().getPluginManager().registerEvents(this, main);
}

@EventHandler
public static void onPlayerQuit(PlayerQuitEvent ev) {
    if (main.scores.containsKey(ev.getPlayer())) {
        main.scores.remove(ev.getPlayer());
    }
}

main plugin = main.getPlugin();
}