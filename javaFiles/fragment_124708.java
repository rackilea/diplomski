@EventHandler
public void onBlockExplosion(BlockExplodeEvent e) {
    for (Block block : e.blockList()) {
        block.breakNaturally();
    }
}