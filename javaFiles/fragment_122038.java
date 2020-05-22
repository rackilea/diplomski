// create runtime default PRNG
SecureRandom rng = new SecureRandom();
// make sure that the rng is seeded by the operating system
rng.nextInt();
// add secret to the pool
rng.setSeed("SOME_SECRET".getBytes(StandardCharsets.UTF_8));
// add time information to the pool
rng.setSeed(System.currentTimeMillis());
// use for e.g. RSA key pair generation