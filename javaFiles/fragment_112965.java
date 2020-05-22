if(cmd.getName().equalsIgnoreCase("duel")){
    if(!(args.length == 1)){
        sender.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.DARK_GREEN + "HuntsCraft" + ChatColor.DARK_RED + "]" + ChatColor.RED + " Usage: /duel <Player>");
        return true;
    }
    else if (args.length == 1){
        Player p = Bukkit.getServer().getPlayer(args[0]);
        if(p != null){
            if(p.equals(sender)){
               sender.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.DARK_GREEN + "HuntsCraft" + ChatColor.DARK_RED + "]" + ChatColor.RED + " You cannot duel yourself!");
                return true;
            }
            else{
                if(duels.containsKey(p) || duels.containsKey(sender)){
                    sender.sendMessage(ChatColor.DARK_RED + "[" + ChatColor.DARK_GREEN + "HuntsCraft" + ChatColor.DARK_RED + "] " + ChatColor.RED + "Either you or " + ChatColor.BLUE + p.getName() + ChatColor.RED + " are already in a duel!");
                    return true;
                }
                else{
                    openKitSelector((Player) sender);

                    //this line was changed from
                    //selecting.put(p.getUniqueId(), ((Player) sender).getUniqueId())
                    //to the new value, with the sender as the key,
                    //and the target as the value.
                    selecting.put(((Player) sender).getUniqueId(), p.getUniqueId()); 
                }
            }
        }
    }
}