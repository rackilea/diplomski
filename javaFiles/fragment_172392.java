@EventHandler
public void onEntityShootBow(EntityShootBowEvent ev) {
    if (ev.getProjectile() instanceof Arrow) {
        Arrow a = (Arrow) ev.getProjectile();
        if (a.getShooter() instanceof Player) {
            ItemStack bow = ev.getBow();
            if (bow.hasItemMeta() && bow.getItemMeta().getDisplayName().equals(ChatColor.AQUA + "Magic" + ChatColor.RED + "Bow")) {
                System.out.println("Launching LightningShot...");
                new LightningShot(arrow).runTaskTimer(this, 0, 1);
            }
        }
    }
}