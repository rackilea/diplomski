public interface F<S, T> { T apply(S s); }


public final class FunctionalStuff {
  private FunctionalStuff() {}


  public <S, T> static List<T> map(Collection<? extends S> collection,
                                   F<? super S, ? extends T> func) {
    final List<T> result = new ArrayList<T>(collection.size()); 
    for (S source : collection)
      result.add(func.apply(source)); 
    return result;
  }


  public <S, T> static List<S> filter(Collection<? extends S> collection,
                                      F<? super S, Boolean> predicate) {
    final List<T> result = new ArrayList<T>(collection.size()); 
    for (S source : collection)
      if (predicate.apply(source))
        result.add(source); 
    return result; 
  }

  // etc etc.
}