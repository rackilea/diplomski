private void rndTeleport(Player p) {
  Location loc = p.getLocation();
  Block highest = p.getWorld().getHighestBlockAt(loc.getBlockX(), loc.getBlockZ());
  Random rnd = new Random();
  double x = rnd.nextInt((100000 - 1) + 1);
  double z = rnd.nextInt((100000 - 1) + 1);
  p.teleport(new Location(p.getWorld(), x, highest.getLocation().getBlockY()+1, z)));
}