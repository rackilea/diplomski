RuneCraft.prospPlayers.add(p.getName());
p.sendMessage(ChatColor.DARK_RED + "You examine the rock for ores...");
Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
    public void run() {
        p.sendMessage(ChatColor.GRAY + "This rock contains" + 
                      ChatColor.DARK_RED + " clay" + ChatColor.GRAY + ".");
        RuneCraft.prospPlayers.remove(p.getName());
    }
}, 3*20L); // TODO: Change time