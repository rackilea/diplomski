if (!usedKit.contains(player.getUniqueId())) {

    // Code to give the kit here...

    usedKit.add(player.getUniqueId()); // Adds the player to the list
} else
    player.sendMessage("You already got your kit.");
return true;