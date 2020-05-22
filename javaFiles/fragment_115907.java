@Override
public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(!(sender instanceOf Player)) {
        sender.sendMessage("Only a player can use this command");
        return true;
    }
    Player player = (Player) sender;
    if(label.equalsIgnoreCase("pvpevent") {
        if(args.length == 0) {
            player.sendMessage("Use: /pvpevent on/off");
            return true;
        } else if(args.length == 1) {
            String mode = args[0];
            if(mode.equalsIgnoreCase("on") {
                Bukkit.getPluginManager().registerEvents(this, this);
                //what you want on /pvpevent on
                return true;
            } else if(mode.equalsIgnoreCase("off") {
                HandlerList.unregisterAll(this);
                //what you want to do if /pvpevent off is entered.
                return true;
            } else {
                //what is called when not off/on is entered after /pvpevent
            }
        }
    }
    return false;
}