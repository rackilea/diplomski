@EventHandler
public void onNormal(CreatureSpawnEvent event) {
    // This will prevent an infinite loop
    if (event.getSpawnReason() != SpawnReason.CUSTOM) {
        event.setCancelled(true);
        // Spawn what you want
    }
}