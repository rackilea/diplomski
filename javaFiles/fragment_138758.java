List<Projectile> visibleProjectiles = new ArrayList<Projectile>();
for (Projectile p : robot.getProjectiles()) {
    if (p.isVisible()) {
        p.update();
        visibleProjectiles.add(p);
    }
}