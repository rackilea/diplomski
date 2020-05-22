if (args[0].equalsIgnoreCase("on")) {
    player.sendMessage(ChatColor.YELLOW + "PVP will be turned on in 5 seconds! Don't move!");
    playersWaiting.add(player.getName());

    Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {

        @Override
        public void run() {
            if (playersWaiting.contains(player.getName())) {
                playersWaiting.remove(player.getName());
                noPVP.remove(player.getName());
                player.sendMessage(ChatColor.YELLOW + "You have turned PVP on!");
            }
        }
    }, 100L);
    return true;
} else if (args[0].equalsIgnoreCase("off")) {
    player.sendMessage(ChatColor.YELLOW + "PVP will be turned off in 5 seconds. Don't move!");
    playersWaiting.add(player.getName());

    this.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {

        @Override
        public void run() {
            if (playersWaiting.contains(player.getName())) {
                playersWaiting.remove(player.getName());
                noPVP.add(player.getName());
                player.sendMessage(ChatColor.YELLOW + "You have turned PVP off!");
            }
        }
    }, 100L);
    return true;
}