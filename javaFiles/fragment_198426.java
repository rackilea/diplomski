@EventHandler
public void onExplode(EntityExplodeEvent e) {

    List<Block> blocks = e.blockList();
    HashMap<Block, Material> blockMap = new HashMap<Block, Material>();
    for(Block b : e.blockList()) {
        blockMap.put(b, b.getType());
    }

    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {

        @Override
        public void run() {
            for(Block b : blocks) {
                b.getLocation().getBlock().setType(blockMap.get(b));
                b.getState().update();
            }
        }
    }, 20*3);
}