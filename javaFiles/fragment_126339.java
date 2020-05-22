// Get an attached sign
Block sign;
if (((sign = block.getRelative(BlockFace.NORTH)).getType() == Material.WALL_SIGN) 
 || ((sign = block.getRelative(BlockFace.EAST)).getType()  == Material.WALL_SIGN)
 || ((sign = block.getRelative(BlockFace.WEST)).getType()  == Material.WALL_SIGN)
 || ((sign = block.getRelative(BlockFace.SOUTH)).getType() == Material.WALL_SIGN)
    org.bukkit.block.Sign data = (Sign) sign.getState();
    data.setLine(1, "OFF");
    data.update();
}