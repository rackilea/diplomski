boolean hasPermission = true;
for(String ranks : plugin.getConfig().getStringList("selllallranks")) {
    if(p.hasPermission("duocraft.sellall." + ranks)) {
        // continuing code
    } else {
        hasPermission = false;
    }
}
if(!hasPermission) {
    // send no permission message.
}