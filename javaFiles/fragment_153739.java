static Instant getInstantFromMicros(Long microsSinceEpoch) {
  return Instant.ofEpochSecond(TimeUnit.MICROSECONDS.toSeconds(microsSinceEpoch), TimeUnit.MICROSECONDS.toNanos(Math.floorMod(microsSinceEpoch, TimeUnit.SECONDS.toMicros(1))));
}

static Instant getInstantFromNanos(Long nanosSinceEpoch) {
  return Instant.ofEpochSecond(0L, nanosSinceEpoch);
}