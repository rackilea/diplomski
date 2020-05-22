else if (spawn.distance(loc) > 11) {
    List<Block> blocks = UHCore.blocksBetweenPoints(player.getLocation().add(2, 2, 2),  
                                                    player.getLocation().subtract(2, 2, 2));
    for (Block block : blocks) {
        if (block.getType() != Material.AIR)
            continue;
        if (block.getLocation().distance(spawn)>15) {
            block.getWorld().playEffect(block.getLocation(), Effect.MOBSPAWNER_FLAMES, 2);
        }
    }
}