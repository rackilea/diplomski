public double distanceToNearestSafeZone(Player player, List<SafeZone> safeZones) {
     double distance;
     double minimumDistance = Double.POSITIVE_INFINITY;
     for(SafeZone safeZone:safeZones) {
          distance = Math.sqrt(Math.pow(player.x-safeZone.x,2) + Math.pow(player.y-safeZone.y,2));
          if(minimumDistance > distance) {
               minimumDistance = distance;
          }
     }
     return minimumDistance - SafeZone.radius;
}