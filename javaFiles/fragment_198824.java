@EventHandler
public void onFromTo(BlockFromToEvent event){
    Material type = event.getBlock().getType();
    if (type == Material.WATER || type == Material.STATIONARY_WATER || type == Material.LAVA || type == Material.STATIONARY_LAVA){
        Block b = event.getToBlock();
        if (b.getType() == Material.AIR){
            if (generatesCobble(type, b)){
                /* DO WHATEVER YOU NEED WITH THE COBBLE */
                event.setCancelled(true);
            }
        }
    }
}

private final BlockFace[] faces = new BlockFace[]{
        BlockFace.SELF,
        BlockFace.UP,
        BlockFace.DOWN,
        BlockFace.NORTH,
        BlockFace.EAST,
        BlockFace.SOUTH,
        BlockFace.WEST
    };

public boolean generatesCobble(Material type, Block b){
    Material mirrorID1 = (type == Material.WATER || type == Material.STATIONARY_WATER ? Material.LAVA : Material.WATER);
    Material mirrorID2 = (type == Material.WATER || type == Material.STATIONARY_WATER ? Material.STATIONARY_LAVA : Material.STATIONARY_WATER);
    for (BlockFace face : faces){
        Block r = b.getRelative(face, 1);
        if (r.getType() == mirrorID1 || r.getType() == mirrorID2){
            return true;
        }
    }
    return false;
}