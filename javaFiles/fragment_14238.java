String randomString = plugin.getRandomStringFromList(plugin.getLocationList());

p.teleport(new Location(Bukkit.getWorld("world"),
  plugin.getConfig().getInt("locations." + randomString + ".x"), 
  plugin.getConfig().getInt("locations." + randomString + ".y"), 
  plugin.getConfig().getInt("locations." + randomString + ".z")));