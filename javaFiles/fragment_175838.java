@EventHandler
public void damage (EntityDamageEvent event) {
    // Get the victim of the damage event.
    Entity victim = event.getEntity();

    // End event, add setCancelled(true), and exit method if the isDamaged modifier is set to true
    if (isDamaged) {
        event.setCancelled(true);
        return;
    }

    if (event instanceof EntityDamageByEntityEvent) {
        // Get the attacker of the event.
        EntityDamageByEntityEvent edbeEvent = (EntityDamageByEntityEvent) event;
        Entity attacker = edbeEvent.getDamager();

        // Continue only if both players are humans and not NPCS.
        if(edbeEvent.getDamager() instanceof Player && victim instanceof Player) {

            // Saving the players as the variable Player.
            final Player player = (Player) victim;
            final Player player2 = (Player) attacker;

            // Add both players to the hashmap to be used by other classes.
            Damagelist.add(player);
            Damagelist.add(player2);

            // Toggle to true.
            isDamaged = true;

            // Get delay time from the config.yml file.
            int delay = plugin.getConfig().getInt("StunDuration") * 20;

            // Setup delayed task to end cooldown set under StunDuration.
            plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                // Define task to be run by scheduler.
                public void run() {         
                    // After amount of time set by StunDuration, remove players from hashmap.
                    Damagelist.remove(player);
                    Damagelist.remove(player2);

                    // Toggle back to false;
                    isDamaged = false;
                    playeradd = true;
                }
            }, delay);
        }
    }
}