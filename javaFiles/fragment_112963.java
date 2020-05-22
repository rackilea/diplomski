//get the UUID of the Player that is being targeted by the Player player
UUID id = selecting.get(player.getUniqueId());

//get the target Player from the UUID above
Player target = Bukkit.getPlayer(id);

//open the kit selector for the target Player above
openKitSelector(target);