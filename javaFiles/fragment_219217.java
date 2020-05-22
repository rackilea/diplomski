public void onEnable(){
    getLogger().info(ChatColor.GREEN + "Credits has been enabled!");

    File pluginDirectory = getDataFolder(); //getting the data folder
    if(!pluginDirectory.exists()){
        pluginDirectory.mkdir(); //Creating the plugin data folder if it doesn't exist.
    }

    File file = new File(pluginDirectory+File.seperator+"Credits.txt"); //Credits.txt inside the plugin directory

    if (file.exists()){ //Checking if Credits.txt exists
        getLogger().info(ChatColor.DARK_GREEN + "Credits File Exists");

    }else{
        getLogger().info(ChatColor.DARK_RED + "Credits File Doesn't Exist!");

        file.createNewFile(); //You probably need to create it too
    }
}