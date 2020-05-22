BukkitRunnable sendMessage = new BukkitRunnable() {
    final int minI = min.getBlockX(), minJ = min.getBlockY(), minK = min.getBlockZ();
    final int maxI = max.getBlockX(), maxJ = max.getBlockY(), maxK = max.getBlockZ();
    int i = minI, j = minJ, k = minK;

    @Override
    public void run() {
        final Block kasamas = Bukkit.getServer().getWorld("paradise").getBlockAt(i, j, k);
        p.sendMessage(" kitas: " + kasamas);
        if (k > maxK) {
            if (j > maxJ) {
                if (i > maxI) {
                    cancel();
                } else {
                    i++;
                    j = minJ;
                    k = minK;
                }
            } else {
                j++;
                k = minK;
            }
        } else {
            k++;
        }
    }
};
sendMessage.runTaskTimer(plugin, 0, 20);