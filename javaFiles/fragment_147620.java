import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class ExamplePlugin extends JavaPlugin
{
  public List<ItemStack> stacks = new ArrayList<ItemStack>();
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if(cmd.getName().equalsIgnoreCase("tester123"))
    {
      ItemStack stack = new ItemStack(272, 0, (byte)0);

      Player p = (Player)sender;
      stacks.add(stack);
      ItemMeta i = stack.getItemMeta();

      List<String> lore = new ArrayList<String>();
      lore.add("Special");
      i.setLore(lore);

      p.getLocation().getWorld().dropItem(((Player)sender).getLocation(), stack);
    }
    return true;
  }

  @EventHandler(priority = EventPriority.HIGHEST)
  public void onItemStackRightClick(PlayerInteractEvent e)
  {
    Player player = e.getPlayer();

      if(player.getItemInHand().getItemMeta().hasLore())
      {
          if (player.getItemInHand().getItemMeta().getLore().get(0).equals("Special"))
          {
              player.sendMessage("You got one of our SPECIAL stone swords!!!!");
          }
      }
  }
}