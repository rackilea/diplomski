// Setting
Location spawn = Player.getLocation();
config.set("spawn.world", spawn.getWorld().getName());
config.set("spawn.x", spawn.getX());
config.set("spawn.y", spawn.getY());
config.set("spawn.z", spawn.getZ());
config.set("spawn.yaw", spawn.getYaw());
config.set("spawn.pitch", spawn.getPitch());
try {
    config.save(fileConfig);
} catch (IOException io) {
    // Unable to save data
}

// Getting
String world = config.getString("spawn.world");
double x = config.getDouble("spawn.x");
double y = config.getDouble("spawn.y");
double z = config.getDouble("spawn.z");
double yaw = config.getDouble("spawn.yaw");
double pitch = config.getDouble("spawn.pitch");
Location spawn = new Location(Server.getWorld(world), x, y, z, (float) yaw, (float) pitch);
Player.teleport(spawn);