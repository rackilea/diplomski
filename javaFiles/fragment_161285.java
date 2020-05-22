public Date getLastPlayedDate(String p){
    String uuid = Bukkit.getOfflinePlayer(p).getUniqueId().toString(); // get the uuid from the OfflinePlayer
    long time = plugin.getConfig().getLong(uuid); // get the time associated with the uuid
    Date date = new Date(time * 1000); // convert the time to the date
    return date; // return the date
}