@EventHandler
public void onEvent(SomeEvent e) {
    for(String command : thePlugin.getConfig().getStringList(configPath)) {
        Bukkit.dispatchCommand(someCommandSender, command)  
    }
}