// for performance reasons, skip change detection (MASK-1) times out of MASK.
// Only once every MASK calls is change detection code executed
// Note that MASK is a variable itself.
if (((invocationCounter++) & mask) != mask) {
  return FilterReply.NEUTRAL;
}