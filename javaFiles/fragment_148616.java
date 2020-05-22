Snowball snowball = player.launchProjectile(Snowball.class);

// Get vectors
Vector i = target.getLocation().toVector();
Vector j = snowball.getLocation().toVector();

// Perform the subtraction, then normalize
Vector r = i.subtract(j);
Vector v = r.normalize();

// then, actually set the speed, in this case, by a magnitude of four
Vector velocity = v.multiply(4);

// Then, set the velocity of the snowball but updating the 'default' velocity of the snowball
snowball.setVelocity(snowball.setVelocity(velocity));