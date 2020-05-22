Multimap<Integer, ClassC> combine(Multimap<Integer, ? extends ClassC> a, Multimap<Integer, ? extends ClassC> b) {
  Multimap<Integer, ClassC> combined = new SetMultimap<Integer, ClassC>();  // or whatever kind you'd like
  combined.putAll(a);
  combined.putAll(b);
  return combined;
}