public final class MyInteger implements Operations{
  private final int delegate;

  public static final OperationsFactory<MyInteger> FACTORY = 
    new OperationsFactory<>() {
      @Override
      MyInteger valueOf(int i) {
        return new MyInteger(i);
      }
    };

  public MyInteger(int i){
      delegate = i;
  }

  @Override
  Operations add(Operations other){
      return new MyInteger(delegate + ((MyInteger) other).delegate);
  }
  @Override
  Operations subtract(Operations other){
    return new MyInteger(delegate - ((MyInteger) other).delegate);
  }
  (...)
}