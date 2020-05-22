LongAdder adder = new LongAdder();
System.out.println(
    Stream.generate(new Supplier<Integer>() {
        int i; @Override public Integer get() { adder.increment(); return i++; }
    }).parallel()
      .limit(10_000)
      .collect(BitSet::new, BitSet::set, BitSet::or)
      .cardinality()
);
System.out.println("queried "+adder+" times");