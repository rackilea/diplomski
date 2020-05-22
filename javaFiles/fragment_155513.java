FreezeListener freezeListener = new FreezeListener();
FreezeCommand freezeCommand = new FreezeCommand( freezeListener); //<- This listener...

public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (label.equalsIgnoreCase("seefrozenlist")){
        for (String s : freezeListener.frozen){ // <-...and this one are now the same listener and will share the list of frozen players
            sender.sendMessage(s);
        }
    }
    return true;
}