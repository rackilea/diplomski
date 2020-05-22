private HubLocation formatLocation(DBObject object){
    World world = Bukkit.getWorld(object.get("world").toString());
    Location location = new Location(world, 
        ((Number)object.get("x")).doubleValue(), 
        ((Number)object.get("y")).doubleValue(), 
        ((Number)object.get("z")).doubleValue(),
        ((Number)object.get("yaw")).floatValue(), 
        ((Number)object.get("pitch")).floatValue());
    return new HubLocation(object.get("name").toString(), location);
}