public ParticleSystem createParticleSystem(final TextureRegion waterDropTextureRegion) {
    //X & Y for the particles to spawn at.
    final float particlesXSpawn = 400;
    final float particlesYSpawn = 300;

    //Max & min rate are the maximum particles per second and the minimum particles per second.
    final float maxRate = 10;
    final float minRate = 5;

    //This variable determines the maximum particles in the particle system.
    final int maxParticles = 100;

    //Particle emitter which will set all of the particles at a ertain point when they are initialized.
    final PointParticleEmitter pointParticleEmtitter = new PointParticleEmitter(particlesXSpawn, particlesYSpawn);

    //Creating the particle system.
    final ParticleSystem particleSystem = new ParticleSystem(pointParticleEmtitter, maxRate, minRate, maxParticles, waterDropTextureRegion);

    //And now, lets create the initiallizers and modifiers.
    //Velocity initiallizer - will pick a random velocity from -20 to 20 on the x & y axes. Play around with this value.
    particleSystem.addParticleInitializer(new VelocityInitializer(-20, 20, -20, 20));

    //Acceleration initializer - gives all the particles the earth gravity (so they accelerate down).
    particleSystem.addParticleInitializer(new GravityInitializer());

    //And now, adding an alpha modifier, so particles slowly fade out. This makes a particle go from alpha = 1 to alpha = 0 in 3 seconds, starting exactly when the particle is spawned.
    particleSystem.addParticleModifier(new AlphaModifier(1, 0, 0, 3));

    //Lastly, expire modifier. Make particles die after 3 seconds - their alpha reached 0.
    particleSystem.addParticleModifier(new ExpireModifier(3));  

    return particleSystem;
}