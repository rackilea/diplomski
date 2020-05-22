package me.flyingscot5.bam_mad_yet;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{

public static main getPlugin() {
    return plugin;
}

private static main plugin;
public static HashMap<Player, Integer> scores;

@Override
public void onEnable() {
    plugin = this;
    scores = new HashMap<Player, Integer>();
    new L_PlayerQuit(this);
    getCommand("isbammadyet").setExecutor(new C_isbammadyet());
    Bukkit.getConsoleSender().sendMessage("\2476Bam Mad Yet \247awas loaded!!!");
}

@Override
public void onDisable() {
    Bukkit.getConsoleSender().sendMessage("\2476Bam Mad Yet \247awas unloaded!!!");
}
}