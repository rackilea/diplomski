Block sign = world.getBlockAt(signLoc); // Get the block
sign.setType(Material.WALL_SIGN); // Set the type to "WALL_SIGN", now it's BlockState is an instance of "Sign"

BlockState signState = sign.getState(); // Get the general state

if (signState instanceof org.bukkit.block.Sign) { // Make sure the sign block really does have the "Sign" BlockState (this isn't really necessary, more of a double check)
    org.bukkit.block.Sign signBlock = (org.bukkit.block.Sign) signState; // Note that this is the org.bukkit.block.Sign interface
    signBlock.setLine(0, "Hello"); // Set the first line
    signBlock.setLine(1, player.getName()); // Set the second line
    if (signState.getData() instanceof org.bukkit.material.Sign) { // Now get the "MaterialData" from the BlockState...
        org.bukkit.material.Sign signMaterialData = (org.bukkit.material.Sign) signState.getData(); // And cast it to org.bukkit.material.Sign
        signMaterialData.setFacingDirection(BlockFace.WEST); // Use this to change the direction of the sign, in this case WEST (sign is placed + X direction of player)
    }
    signBlock.update(); // Update the sign's state
}