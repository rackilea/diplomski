public class GroupBy<X> implements Function<X, Stream<X>>{

  private final BiPredicate<X, X> groupBorder;
  private final BinaryOperator<X> combiner;
  private X latest = null;

  public GroupBy(BiPredicate <X, X> groupBorder,
                 BinaryOperator<X> combiner) {
    this.groupBorder = groupBorder;
    this.combiner = combiner;
  }

  @Override
  public Stream<X> apply(X elem) {
    // TODO: add test on end marker as additonal parameter for constructor
    if (elem==null) {
      return latest==null ? Stream.empty() : Stream.of(latest);
    }
    if (latest==null) {
      latest = elem;
      return Stream.empty();
    }
    if (groupBorder.test(latest, elem)) {
      Stream<X> result = Stream.of(latest);
      latest = elem;
      return result;
    }
    latest = combiner.apply(latest,  elem);
    return Stream.empty();
  }
}