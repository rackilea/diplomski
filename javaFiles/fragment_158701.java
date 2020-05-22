boolean read = false;
String msg = "default message";
List<String> players = new ArrayList<String>();

for (String argument : args) {
    if (!read && !argument.equalsIgnoreCase("-")) {
        players.add(argument);
    } else if (!read && argument.equalsIgnoreCase("-")) {
        read = true;
        msg = "";
    } else {
        msg += argument;
    }
}

for (String player : players) {
    Player target = Bukkit.getServer().getPlayer(player);
    target.kickPlayer(msg);
}