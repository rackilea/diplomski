Player ply = (player who's name is mentioned)
String message = "<message>"

on.playNote(on.getLocation(), Instrument.PIANO, Note.natural(1, Tone.A)); //send the player the music
String s = message.replaceAll(ply.getName(), ChatColor.GOLD + ChatColor.UNDERLINE + ply.getName()); //change format of player's name
ply.sendMessage(s); //send message to the player