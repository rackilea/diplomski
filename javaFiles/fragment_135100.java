public static volatile boolean  lockchat    = false;

public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
    // If this is not the 'lockchat' command, then fail fast
    if (!label.equalsIgnoreCase("lockchat")) return true;

    // If s is a Player then check the player has permission and fail fast
    // if not.
    if (s instanceof Player) {
        Player p = (Player) s;
        if (!p.hasPermission("duocraft.lockchat")) {
            p.sendMessage("no access");
            return true;
        }
    }

    switch (args.length) {
    case 0:
        lockchat = !lockchat;
        s.sendMessage(lockchatStatus());
        break;
    case 1:
        int ticks = Integer.valueOf(args[0]) * 20;
        final boolean originalLockChat = lockchat;
        lockchat = !originalLockChat;
        s.sendMessage(lockchatStatus());
        plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, new Runnable() {
            @Override
            public void run() {
                lockchat = originalLockChat;
                Bukkit.broadcastMessage(lockchatStatus() + ".");
                plugin.getServer().getScheduler().cancelTasks(plugin);
            }
        }, ticks, ticks);
        break;
    default:
        s.sendMessage("Too many arguments. </lockchat [time]>");
        break;
    }
    return true;
}

private String lockchatStatus() {
    return lockchat ? "locked" : "unlocked";
}