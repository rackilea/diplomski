public int compare(final Person p1, final Person p2)
{
  return ComparisonChain.start()
      .compare(p1.getName().toLowerCase(), p2.getName().toLowerCase())
      .compare(p1.getName(), p2.getName())
      .result();
}