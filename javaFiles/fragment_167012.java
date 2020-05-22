// in GameLoop definition

private Bitmap particleA;
private Bitmap particleB;

// somewhere in GameLoop constructor
particleA = BitmapFactor.decodeResource (activity.getResources(), R.drawable.particle_a);
particleB = BitmapFactor.decodeResource (activity.getResources(), R.drawable.particle_b);

// where you build your particle
Particle (GameLoop gl, ...) {
   oneLevelDown = new OneLevelDown(GameLoop gl, ...);
}

OneLevelDown (GameLoop gl, ...) {
   twoLevelDown = new TwoLevelDown(GameLoop gl, ...);
}

TwoLevelDown (GameLoop gl, ...) {
   particleABitmap = gl.getParticleA(); // simple getter
   particleBBitmap = gl.getParticleB(); // simple getter
}