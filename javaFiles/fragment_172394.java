@EventHandler
public void onEntityShootBow(EntityShootBowEvent ev) {
    if (ev.getProjectile() instanceof Arrow) {
        Arrow a = (Arrow) ev.getProjectile();
        if (a.getShooter() instanceof Player) {
            System.out.println("Launching LightningShot...");
            new LightningShot(a);
        }
    }
}