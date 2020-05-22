@Override
public int compareTo(Os o) {
  return ComparisonChain.start()
       .compare(list.size(), o.list.size())
       .compare(list, o.list, Ordering.natural().<Element>lexicographical())
       .result();
}