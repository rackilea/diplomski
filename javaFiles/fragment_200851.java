public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {       
    if(cmd.getName().equalsIgnoreCase("command")){
        String myString = "";

        for(int i = 0; i < args.length(); i++){
            String arg = args[i] + " ";
            myString = myString + arg;
        }

        sender.sendMessage(myString); //send the message to the command sender.
    }
}