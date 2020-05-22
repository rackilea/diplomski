final Equivalence<SampleClass> byId = new SampleClassIdEquivalence();

byId.equivalent(o1, o2);

Set<Equivalence.Wrapper<SampleClass>> set = ...

set.add(byId.wrap(whatever));