ByteArrayDataOutput out = ByteStreams.newDataOutput();
 out.writeUTF("Connect");
 out.writeUTF("pvp");    
 //applies to the player you send it to. aka Kick To Server.
 Player player = Bukkit.getPlayerExact("Example");
 player.sendPluginMessage(this, "BungeeCord", out.toByteArray());