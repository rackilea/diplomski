public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    if (cmd.getName().equalsIgnoreCase("idk")) {
        if (sender.getName().equalsIgnoreCase("SOS")) {
            sender.sendMessage("You are SOS");
        } else {
            sender.sendMessage("You are not SOS!");
        }
        return true;
    }
    return false;
}