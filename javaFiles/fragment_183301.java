if(cmd.getName().equalsIgnoreCase("fakeop")){
  if(!sender.hasPermission("fake.op")){
    sender.sendMessage(ChatColor.RED + "Access denied.");
    return true;
  }
  if(args.length == 0){
    sender.sendMessage(ChatColor.RED + "Please specify a player!");
    return true;
  }

  Player target = Bukkit.getServer().getPlayer(args[0]);

  if(target == null){
    sender.sendMessage(ChatColor.RED + "Player must be online!");
  }
  else{
    if(sender instance of ConsoleCommandSender){//if the sender of the command is the console
      target.setOp(true); //op the player
    }
    target.sendMessage(ChatColor.YELLOW + "You are now op!");
  }
  return true;
}