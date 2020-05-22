import java.util.ArrayList;
import java.util.List;

interface F<A,R> {
   public R apply(A a);
}

interface Functor<A, FClass extends Functor<?, FClass>> {
   public <B> FClass fmap(F<A,B> f);
}

public class ListFunctor<A> implements Functor<A, ListFunctor<?>> {
  final private List<A> list;
  public ListFunctor(List<A> list) {
     this.list = list;
  }

  @Override
  public <B> ListFunctor<B> fmap(F<A,B> f) {
     List<B> result = new ArrayList<B>();
     for(A a: list) result.add(f.apply(a));
     return new ListFunctor<B>(result);
  }
}