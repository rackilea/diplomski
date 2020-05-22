public void scheduleTimer(Plugin plugin, final World world) {
    plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
        public void run() {
            long time = world.getTime();
            // -469 78 418
            // -469 30 433
            if (time == 13000) {
                int x = -469;
                for (int y = 30; y < 80; y++) {
                    for (int z = 402; z < 418; z++) {
                        Location location = new Location(e.getWorld(), x, y, z);
                        location.getBlock().setType(Material.BRICK);

                    }
                }
            }
        }
    }, 1, 1);
}