if (offset == nextStart) {
  /*
   * This occurs when some pattern has an empty match, even if it
   * doesn't match the empty string -- for example, if it requires
   * lookahead or the like. The offset must be increased to look for
   * separators beyond this point, without changing the start position
   * of the next returned substring -- so nextStart stays the same.
   */
  offset++;
  if (offset > toSplit.length()) {
    offset = -1;
  }
  continue;
}