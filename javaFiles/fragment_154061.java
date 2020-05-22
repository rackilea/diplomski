@EventHandler
public void onPlayerMove(PlayerMoveEvent e)
{
    for(int x = e.getPlayer().getLocation().getBlockX() - 1; x < x + 2; x++)
    {
        for(int z = e.getPlayer().getLocation().getBlockZ() - 1; z < z + 2; z++)
        {
            Block b = e.getPlayer().getWorld().getBlockAt(x, e.getPlayer().getLocation().getBlockY(), z);

            if(b.getType() != Material.AIR)
            {
                doSomething();
            }
        }
    }
}