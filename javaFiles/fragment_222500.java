@EventHandler
public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
    if (event.getDamager() instanceof Egg && event.getEntity() instanceof LivingEntity) { // If damager is an egg and hurt entity is a living entity
        LivingEntity hurt = (LivingEntity) event.getEntity(); // Cast living entity so we can use damage() method
        event.setCancelled(true); // Cancel the event, removing any knockback/velocity changes
        hurt.damage(event.getFinalDamage()); // Re-apply final/original damage
    }
}