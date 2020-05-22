ByteArrayDataOutput out = ByteStreams.newDataOutput();
 out.writeUTF("ConnectOther");
 out.writeUTF("Example");
 out.writeUTF("pvp");
 //Any online player at all.
 //Aka Pull To Server.
 Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
 player.sendPluginMessage(this, "BungeeCord", out.toByteArray());