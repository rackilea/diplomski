// experiments indicate that even for CPU intensive applications with 200 or more threads MASK
  // values in the order of 0xFFFF is appropriate
  private static final int MAX_MASK = 0xFFFF;


  // if less  than MASK_INCREASE_THRESHOLD milliseconds elapse between invocations of updateMaskIfNecessary() method,
  // then the mask should be increased
  private static final long MASK_INCREASE_THRESHOLD = 100;

  // if more than MASK_DECREASE_THRESHOLD milliseconds elapse between invocations of updateMaskIfNecessary() method,
  // then the mask should be decreased
  private static final long MASK_DECREASE_THRESHOLD = MASK_INCREASE_THRESHOLD*8;

  // update the mask so as to execute change detection code about once every 100 to 8000 milliseconds.
  private void updateMaskIfNecessary(long now) {
    final long timeElapsedSinceLastMaskUpdateCheck = now - lastMaskCheck;
    lastMaskCheck = now;
    if (timeElapsedSinceLastMaskUpdateCheck < MASK_INCREASE_THRESHOLD && (mask < MAX_MASK)) {
        mask = (mask << 1) | 1;
    } else if (timeElapsedSinceLastMaskUpdateCheck > MASK_DECREASE_THRESHOLD) {
      mask = mask >>> 2;
    }
  }