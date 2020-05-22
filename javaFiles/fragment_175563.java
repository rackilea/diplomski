public void brake(final double amplitude) {
    // check preconditions
    if (speed == 0) throw new IllegalStateException("cannot brake when standing");
    if (amplitude <= 0) throw new IllegalArgumentException("amplitude must be positive");
    // ... do other important checks
    doBrake(amplitude);
}
private void doBrake(final double amplitude) {
    // The real code goes here
}