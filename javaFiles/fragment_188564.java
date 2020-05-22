System.out.println(
    Stream.generate(new Supplier<Integer>() {
        int i; @Override public Integer get() { return i++; }
    }).parallel()
      .limit(10_000)
      .collect(BitSet::new, BitSet::set, BitSet::or)
      .cardinality()
);