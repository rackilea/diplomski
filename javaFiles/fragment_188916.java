public commands(MainClass plugin) {
    mainclass = plugin;
}
int cooldown;
int i = 10;
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    final Player player = (Player) sender;

    if(cmd.getName().equalsIgnoreCase("timer")) {
        cooldown = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(mainclass, new Runnable(){

            public void run(){
                if(i != -1){
                    if(i != 0){
                        Bukkit.broadcastMessage(ChatColor.AQUA + "" + i);
                        ItemStack test = Manager.getManager().setNameAndLore(Material.APPLE, i, "lolz", "lolzz");
                        ItemStack testremove = Manager.getManager().setNameAndLore(Material.APPLE, 64, "lolz", "lolzz");
                        player.sendMessage(mainclass.getConfig().getBoolean("wom.players." + player + ".rogue") + "");
                        player.getInventory().removeItem(testremove);
                        player.getInventory().addItem(test);
                        i--;
                    }else{
                        Bukkit.broadcastMessage(ChatColor.GREEN + "begin");
                        i--;
                        Bukkit.getServer().getScheduler().cancelTask(cooldown);

                    }
                }
            }

        },0L ,20L );
        i = 10;
    }