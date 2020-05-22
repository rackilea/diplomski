private void collision() {
    for (final Rocket rocket : rockets) {
        final Iterator<Projectile> iter = projectiles.iterator();
        while (iter.hasNext()) {
            final Projectile projectile = iter.next();
            if (rocket.bounds().intersects(projectile.bounds())) {
                rocket.die();
                stats.addScore(rocket);
                Particle p = new Particle(20, 20, 20, 50);
                particles.add(p);
                iter.remove();
            }
        }
    }
}