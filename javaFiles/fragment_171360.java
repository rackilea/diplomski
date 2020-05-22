for(String key : plugin.getConfig().getConfigurationSection("sellall")){
    Material material = Material.valueOf(key); //the material
    int value = plugin().getConfig().getInt("sellall." + key); //the sell price of the material

    //the rest of your code here
}