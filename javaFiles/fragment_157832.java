@Override
public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
        @Override
        public void run() {
            Bukkit.broadcastMessage(Utils.chat("&6This works"));
        }
    }, 300L);
}