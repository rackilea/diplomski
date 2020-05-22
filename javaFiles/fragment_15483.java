new PrefixQuery(prefix) {
  public Query rewrite(final IndexReader reader) throws IOException {
    try {
      return super.rewrite(reader);
    } catch (final TooManyClauses e) {
      log.debug("falling back to ConstantScoreQuery for prefix " + prefix + " (" + e + ")");
      final Query q = new ConstantScoreQuery(new PrefixFilter(prefix));
      q.setBoost(getBoost());
      return q;
    }
  }
};