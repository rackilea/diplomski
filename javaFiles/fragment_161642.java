interface MemoizableFunction<I, O> extends Function<I, O> {

    //in apply, always recurse to the "recursive Function"
    O apply(I input);

    setRecursiveFunction(Function<? super I, ? extends O>);
}

final MemoizableFunction<Integer, Integer> fact = new MemoizableFunction<Integer, Integer>() {

  private Function<Integer, Integer> recursiveFunction = this;

  @Override
  public Integer apply(final Integer input) {
    System.out.println("Fact: " + input);
    if(input == 1)
        return 1;
    else return input * recursiveFunction.apply(input -1);
  }

  //...
};