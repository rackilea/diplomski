@EventHandler
public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
    if (event.getDamager() instanceof Egg) { // If damager is an egg
        final Entity hurt = event.getEntity(); // Declare entity final so that we can use it in future scheduling
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() { // Schedule a delayed task to run in one tick, plugin is main class
            public void run() { 
                hurt.setVelocity(new Vector(0, 0, 0)); // Set velocity to zero vector, cancelling all motion
            }
        });
    }
}