Set<Sting> unPermitted = new HashSet<>();
for(String ranks : plugin.getConfig().getStringList("selllallranks")) {
    if(p.hasPermission("duocraft.sellall." + ranks)) {
        // continuing code
    } else {
        unPermitted.add(ranks);
    }
}
if(!unPermitted.isEmpty()) {
    // send no permission message.
}