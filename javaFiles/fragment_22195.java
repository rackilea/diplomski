class KhronosDateTime /* doesn't extend Date */ {
  private final Date date;

  KhronosDateTime(long time) {
    this.date = new Date(time);
  }

  // Whatever methods using date.
}