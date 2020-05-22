package me.ghostyy.killmoney;

import java.math.BigDecimal;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import com.earth2me.essentials.api.Economy;

import org.bukkit.event.Listener;   //importing the Listener

public class DeathListener implements Listener {  //You have to implement the Listener to use it!

@EventHandler
public void deathEvent(PlayerDeathEvent e) {
    Player killer = e.getEntity().getKiller();
    Player victim = e.getEntity();
    if (killer == null)
        return; 
    try {
        double amount = Economy.getMoneyExact(victim.getName()).doubleValue() / 10.0D;
        victim.sendMessage("[§bKillMoney§f]§e You killed §b" + killer.getName() + "§e, you got " + (int)amount + "$!");
        Economy.substract(victim.getName(), BigDecimal.valueOf(amount));
        Economy.add(killer.getName(), BigDecimal.valueOf(amount));
        killer.sendMessage("[§bKillMoney§f]§b " + victim.getName() + "killed you, and lost " + (int)amount + "§e$!");
    } catch (Exception e1) {
        return;
    } 
}

}