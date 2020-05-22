public final class Example<M, T extends Example.Delegate<M, T>> {

  public interface Delegate<M, Subtype extends Delegate<M, Subtype>> {
    public M myMethod(Subtype t);
  }

  private T delegate;


    private static class Impl1 implements Delegate<String, Impl1> {

      @Override
      public String myMethod(final Impl1 t) {
        return null;
      }

  }

  public static void main(String[] args) {
    Example<String, Impl1> example =  new Example<>();
    example.delegate = new Impl1();
    example.delegate.myMethod(example.delegate); //works but whout?
  }
}