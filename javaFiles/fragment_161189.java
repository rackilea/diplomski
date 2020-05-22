@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@OperationsPerInvocation(Measure.SIZE)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@State(Scope.Thread)
@Fork(1)
public class Measure
{
  static final int SIZE = 1;

  @Benchmark public Either<Throwable, Integer> workMonadically() {
    final Either<Throwable,Integer> result =
        Try(this::getInput).flatMap((s) ->
            Try(this::getInput).flatMap((s2) ->
                parseInt(s).flatMap((i) ->
                    parseInt(s2).map((i2) ->
                            i + i2
                    ))));
    return result;
  }

  @Benchmark public Object workImperatively() {
    Object result;
    try {
      final String s = getInput();
      final String s2 = getInput();

      final int i = parzeInt(s);
      final int i2 = parzeInt(s2);
      result = i + i2;
    }catch(Throwable t){
      result=t;
    }
    return result;
  }

  public String getInput() {
    final Integer value = ThreadLocalRandom.current().nextInt();
    if (value % 2 == 0) return "Surprise!!!";
    return String.valueOf(value);
  }

  public Either<Throwable,Integer> parseInt(final String s){
    try{
      return Either.right(Integer.parseInt(s));
    }catch(final Throwable t){
      return Either.left(t);
    }
  }

  public Integer parzeInt(final String s){
    return Integer.parseInt(s);
  }

  public static abstract class Either<L,R>
  {
    public static <L,R> Either<L,R> left(final L l){
      return new Left<>(l);
    }

    public static <L,R> Either<L,R> right(final R r){
      return new Right<>(r);
    }

    public static<L,R> Either<L,R> toEither(final Optional<R> oR,final L l){
      return oR.isPresent() ? right(oR.get()) : left(l);
    }

    public static <R> Either<Throwable,R> Try(final Supplier<R> sr){
      try{
        return right(sr.get());
      }catch(Throwable t){
        return left(t);
      }
    }

    public abstract <R2> Either<L,R2> flatMap(final Function<R,Either<L,R2>> f);

    public abstract  <R2> Either<L,R2> map(final Function<R,R2> f);

    public abstract  <L2> Either<L2,R> leftMap(final Function<L,L2> f);

    public abstract  Either<R,L> swap();

    public static class Left<L,R> extends Either<L,R> {
      final L l;

      private Left(final L l){
        this.l=l;
      }

      @Override public <R2> Either<L,R2> flatMap(final Function<R,Either<L,R2>> f){
        return (Either<L,R2>)this;
      }

      @Override public <R2> Either<L,R2> map(final Function<R,R2> f){
        return (Either<L,R2>)this;
      }

      @Override public <L2> Either<L2,R> leftMap(final Function<L,L2> f){
        return new Left<>(f.apply(l));
      }

      @Override public Either<R,L> swap(){
        return new Right<>(l);
      }
    }

    public static class Right<L,R> extends Either<L,R> {
      final R r;

      private Right(final R r){
        this.r=r;
      }

      @Override public <R2> Either<L,R2> flatMap(final Function<R,Either<L,R2>> f){
        return f.apply(r);
      }

      @Override public <R2> Either<L,R2> map(final Function<R,R2> f){
        return new Right<>(f.apply(r));
      }

      @Override public <L2> Either<L2,R> leftMap(final Function<L,L2> f){
        return (Either<L2,R>)this;
      }

      @Override public Either<R,L> swap(){
        return new Left<>(r);
      }
    }
  }
}