public Random() {
    // Note: Don't use identityHashCode(this) since that causes the monitor to
    // get inflated when we synchronize.
    setSeed(System.nanoTime() + seedBase);
    ++seedBase;
}