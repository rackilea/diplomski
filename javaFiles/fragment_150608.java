// Inside your "PlayerMoveEvent" method

// If a player is not on the ground and has fallen more than two blocks
if (!((CraftPlayer) player).isOnGround() && player.getFallDistance() > 2) {
    Location to = event.getTo().clone().subtract(0, 0.0001, 0); // Get the location they will be at next tick
    if (to.getBlock().getType() != Material.AIR) { // If that block is not air
        player.setAllowFlight(false); // Cancel their ability to fly so that they take regular fall damage
    }
}