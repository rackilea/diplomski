/**
 * Called by the timer when the next iteration is due. Assume that
 * this happens at the right moment.
 */
public void onTimerUpdate() {
  updateAnimation();

  // Compute the next point in time that corresponds to the
  // frame rate you want.
  long nextScheduledTimestamp = getNextTimestampInNanos();

  long nanos = System.timeNanos();
  timer.schedule(task, convertToMillis(nextScheduledTimestamp - nanos));
}