String storage[] = new String[100];

@EventHandler
public void OnPlaceofDiamond(BlockPlaceEvent e) {
    Player player = e.getPlayer();
    int i = 0;

    if(e.getBlock().getType() == Material.DIAMOND_BLOCK){
        if(Arrays.asList(storage).contains(player.getName())){
            player.sendMessage(ChatColor.BLUE + "You are on the list");
        }
        else{
            player.sendMessage(ChatColor.BLUE + "DIAMONDS!!");
            storage[i] = player.getName();
            i++;
        }
    }
}