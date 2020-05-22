public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    if (args.length < 2) { // Handle too few arguments
        // sender.sendMessage("Too few arguments...");
        // return true;
    }
    final int b = Integer.parseInt(args[1]);
    //Integer to find the bounty amount
    if (!(sender instanceof Player)) {
        sender.sendMessage(ChatColor.RED + "[" + ChatColor.GREEN + "Bounty" + ChatColor.RED + "] " + ChatColor.GOLD + "In game use only!");
        return true;
    }
    ...