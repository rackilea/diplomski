List<Class<? extends A>> myOrder = ImmutableList.of(
    A1.class, A4.class, A3.class, A2.class);
Ordering<A> explicitByClassOrdering = Ordering.explicit(myOrder)
    .onResultOf(new Function<A, Class<? extends A>>() {
      @Override public Class<? extends A> apply(A a) {
        return a.getClass();
      }
    });

System.out.println(explicitByClassOrdering.sortedCopy(
    ImmutableList.of(new A3(), new A2(), new A3(), new A1(), new A4())));
// [Test$A1, Test$A4, Test$A3, Test$A3, Test$A2]