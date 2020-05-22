private HashMap<UUID, Long> abilityCooldown = new HashMap<>();

public void onEvent(SomePlayerEvent event) {
    // Player is trying to use some ability...

    // It's usually safer to store IDs rather than names or player objects for various reasons
    UUID id = event.getPlayer().getUniqueId();
    if (!abilityCooldown.containsKey(id)) { // They are not in the map, so have never tried to use the ability yet
        // Let them use the ability here...
        int seconds = 5; // The amount of time to cool down for
        // Put the player's ID and the time when they will be allowed to use the ability again (future)
        abilityCooldown.put(id, System.currentTimeMillis() + 1000 * seconds);
    } else {
        // The time when they are allowed to use the ability again (we put this in the map when they used it last)
        long time = abilityCooldown.get(id);
        if (time > System.currentTimeMillis()) { // If that time is still in the future
            // Do not allow them to use the ability (maybe send them a message)
        } else {
            // Let them use the ability here...
            int seconds = 5; // The amount of time to cool down for
            abilityCooldown.put(id, System.currentTimeMillis() + 1000 * seconds); // Update the time when they can use the ablity again
        }
    }
}