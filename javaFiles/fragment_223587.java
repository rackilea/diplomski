public static class RankedException extends Exception {
  private final int rank;

  public RankedException(Throwable t) {
    this(0, t);
  }

  public RankedException(int rank, Throwable t) {
    super(t);
    this.rank = rank;
  }
}