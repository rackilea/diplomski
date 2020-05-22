package me.Pixel;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    public static Main plugin;
    public Set<String> spells = new HashSet<String>();

    @Override
    public void onEnable() {
        plugin = this;
        this.getServer().getPluginManager().registerEvents(this, this);
        spells.add("LightningShot");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("bow")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You need to be an in-game player to execute this command!");
            } else {
                Player p = (Player) sender;
                if (sender.hasPermission("bow.bow")) {
                    ItemStack stack = new ItemStack(Material.BOW);
                    ItemMeta stackMeta = stack.getItemMeta();
                    stackMeta.setDisplayName(ChatColor.AQUA + "Magic" + ChatColor.RED + "Bow");
                    stack.setItemMeta(stackMeta);
                    p.getInventory().addItem(stack);
                    p.sendMessage("You now have the powerfull Magic Bow");
                } else {
                    sender.sendMessage(ChatColor.RED + "No Permission!");
                }
            }
        }
        return false;
    }

    @EventHandler
    public void onEntityShootBow(EntityShootBowEvent ev) {
        if (ev.getProjectile() instanceof Arrow) {
            Arrow a = (Arrow) ev.getProjectile();
            if (a.getShooter() instanceof Player) {
                ItemStack bow = ev.getBow();
                if (bow.hasItemMeta() && bow.getItemMeta().getDisplayName()
                        .equals(ChatColor.AQUA + "Magic" + ChatColor.RED + "Bow")) {
                    new LightningShot(a);
                }
            }
        }
    }
}