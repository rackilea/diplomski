public List<Location> customBlocks = new ArrayList<Location>();

//... in the block place event add the block's location to the list

@EventHandler
public void onBlockBreak(BlockBreakEvent broke){

    Player player = broke.getPlayer();
    PlayerInventory inventory = broke.getPlayer().getInventory();
    World world = player.getWorld();
    Material block = broke.getBlock().getType();


    if(customBlocks.contains(block.getLocation())){
        //custom block
        block.setType(Material.AIR); //destroy the block
    }

}