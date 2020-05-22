public class RngAnd<A> {
  public final RNG rng;
  public final A a;
  public RngAnd(RNG rng, A a) {
    this.rng = rng;
    this.a = a;
  }
} 

@FunctionalInterface
public interface Rand<A> {
  RngAnd<A> apply(RNG rng);
}

public static <A> Rand<A> unit(A a) {
  return rng -> new RngAnd<A>(rng, a);
  //I think that syntax is right, I haven't used it. In Java 7 it would be:
  return new Rand<A>{
    public RngAnd<A> apply(Rng rng) {
      return new RngAnd<A>(rng, a);
    }
  };
}